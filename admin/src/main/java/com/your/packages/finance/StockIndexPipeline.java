package com.your.packages.finance;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.alibaba.fastjson.JSONArray;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.your.packages.finance.model.entity.StockIndexItem;
import com.your.packages.finance.service.StockIndexItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@PipelineName("stockIndexPipeline")
@Component
@Slf4j
public class StockIndexPipeline implements Pipeline<StockIndexItemGecco> {

	@Autowired
	StockIndexItemService stockIndexItemService;

	@Override
	public void process(StockIndexItemGecco itemGecco) {
		// invalid status
		if (!Objects.equals(itemGecco.getStatus(), 0)) {
			log.warn("==> invalid status, {}", itemGecco.getStatus());
			return;
		}

		final String indexCode = itemGecco.getIndexCode();
		final List<JSONArray> hq = itemGecco.getHq();
		List<StockIndexItem> list = hqToStockIndexItem(indexCode, hq);

		if (CollectionUtils.isEmpty(list)) {
			return;
		}

		// save to db
		log.info("start to save to db");
		final TimeInterval timer = DateUtil.timer();
		stockIndexItemService.saveBatchSomeColumn(list);
		log.info("end to save to db, size: {}, spend: {}ms", list.size(), timer.intervalMs());
	}

	private List<StockIndexItem> hqToStockIndexItem(String indexCode, List<JSONArray> hq) {
		return hq.stream()
				.map(it -> {
					// 日期0 	开盘1 	收盘2 	涨跌额3 	涨跌幅4 	最低5 	最高6 	成交量(手)7 	成交金额(万)8 	换手率9
					// "2021-09-03","3602.74","3581.73","-15.31","-0.43%","3569.40","3613.95","614532352","74384080.00","-"
					final StockIndexItem item = new StockIndexItem();
					item.setCode(indexCode);
					item.setDate(DateUtil.toLocalDateTime(DateUtil.parseDate(it.getString(0))));
					item.setPriceStart(Double.parseDouble(it.getString(1)));
					item.setPriceStop(Double.parseDouble(it.getString(2)));
					item.setPriceBetween(Double.parseDouble(it.getString(3)));
					item.setPriceBetweenRatio(Double.parseDouble(it.getString(4).replace("%", "")) * 0.01);
					item.setPriceMin(Double.parseDouble(it.getString(5)));
					item.setPriceMax(Double.parseDouble(it.getString(6)));
					item.setTransactionHands(Long.parseLong(it.getString(7)));
					item.setTransactionAmount(Double.parseDouble(it.getString(8)));
					item.setExchangeRate(it.getString(9).contains("-") ? null : Double.parseDouble(it.getString(9)));
					final LocalDateTime now = LocalDateTime.now();
					item.setCreateTime(now);
					item.setUpdateTime(now);
					return item;
				})
				.collect(Collectors.toList());
	}

}
