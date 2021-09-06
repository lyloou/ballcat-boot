package com.your.packages.finance.service.impl;

import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import com.your.packages.finance.mapper.StockIndexItemSyncInfoMapper;
import com.your.packages.finance.model.entity.StockIndexItemSyncInfo;
import com.your.packages.finance.model.qo.StockIndexItemSyncInfoQO;
import com.your.packages.finance.model.vo.StockIndexItemSyncInfoPageVO;
import com.your.packages.finance.service.StockIndexItemSyncInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 指数条目同步信息
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Service
public class StockIndexItemSyncInfoServiceImpl extends ExtendServiceImpl<StockIndexItemSyncInfoMapper, StockIndexItemSyncInfo> implements StockIndexItemSyncInfoService {

	/**
	 * 根据QueryObeject查询分页数据
	 *
	 * @param pageParam 分页参数
	 * @param qo        查询参数对象
	 * @return PageResult<StockIndexItemSyncInfoPageVO> 分页数据
	 */
	@Override
	public PageResult<StockIndexItemSyncInfoPageVO> queryPage(PageParam pageParam, StockIndexItemSyncInfoQO qo) {
		return baseMapper.queryPage(pageParam, qo);
	}


}
