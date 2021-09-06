package com.your.packages.finance.converter;

import com.your.packages.finance.model.entity.StockIndexItemSyncInfo;
import com.your.packages.finance.model.vo.StockIndexItemSyncInfoPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 指数条目同步信息模型转换器
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Mapper
public interface StockIndexItemSyncInfoConverter {

	StockIndexItemSyncInfoConverter INSTANCE = Mappers.getMapper(StockIndexItemSyncInfoConverter.class);

	/**
	 * PO 转 PageVO
	 * @param stockIndexItemSyncInfo 指数条目同步信息
	 * @return StockIndexItemSyncInfoPageVO 指数条目同步信息PageVO
	 */
	StockIndexItemSyncInfoPageVO poToPageVo(StockIndexItemSyncInfo stockIndexItemSyncInfo);

}
