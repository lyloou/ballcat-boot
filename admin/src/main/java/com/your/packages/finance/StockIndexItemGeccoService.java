package com.your.packages.finance;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.hccake.extend.mybatis.plus.toolkit.WrappersX;
import com.your.packages.finance.model.entity.StockIndexItemSyncInfo;
import com.your.packages.finance.service.StockIndexItemSyncInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lilou
 * @since 2021/9/6
 */
@Service
@Slf4j
public class StockIndexItemGeccoService {
	@Autowired
	private StockIndexItemSyncInfoService stockIndexItemSyncInfoService;

	@Autowired
	private StockIndexItemGeccoService stockIndexItemGeccoService;

	@Resource
	protected SpringPipelineFactory springPipelineFactory;

	public void start(String indexCode, int start, int end) {
		log.info("start sync, indexCode: {}, start: {}, end: {}", indexCode, start, end);
		final TimeInterval timer = DateUtil.timer();
		final String url = String.format("https://q.stock.sohu.com/hisHq?code=%s&start=%s&end=%s", indexCode, start, end);
		HttpGetRequest seed = new HttpGetRequest(url);
		seed.setCharset("GBK");

		GeccoEngine.create()
				.pipelineFactory(springPipelineFactory)
				.classpath("com.your.packages.finance")
				.seed(seed)
				.run();
		log.info("end sync, indexCode: {}, start: {}, end: {}, spend: {}ms", indexCode, start, end, timer.intervalMs());
	}


	public void sync() {
		final List<StockIndexItemSyncInfo> stockIndexItemSyncInfos = stockIndexItemSyncInfoService.getBaseMapper()
				.selectList(WrappersX.<StockIndexItemSyncInfo>lambdaQueryX()
						.le(StockIndexItemSyncInfo::getStart, LocalDateTime.now())
				);
		if (stockIndexItemSyncInfos.isEmpty()) {
			log.info("sync finished!");
			return;
		}

		for (StockIndexItemSyncInfo syncInfo : stockIndexItemSyncInfos) {
			final LocalDateTime startDate = syncInfo.getStart();
			// set to newer (200 day/次)
			final LocalDateTime endTimeAfter200 = startDate.plusDays(200);
			final LocalDateTime nowDate = LocalDateTime.now();
			final LocalDateTime endDate = endTimeAfter200.isAfter(nowDate) ? nowDate : endTimeAfter200;

			int start = Integer.parseInt(startDate.format(DatePattern.PURE_DATE_FORMATTER));
			int end = Integer.parseInt(endDate.format(DatePattern.PURE_DATE_FORMATTER));
			stockIndexItemGeccoService.start(syncInfo.getCode(), start, end);

			syncInfo.setStart(endDate.plusDays(1));
			log.info("change to new syncInfo: {}", syncInfo);
			stockIndexItemSyncInfoService.updateById(syncInfo);
		}

		sync();
	}
}
