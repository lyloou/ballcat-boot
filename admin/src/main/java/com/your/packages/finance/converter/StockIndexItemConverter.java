package com.your.packages.finance.converter;

import com.your.packages.finance.model.entity.StockIndexItem;
import com.your.packages.finance.model.vo.StockIndexItemPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 指数条目模型转换器
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Mapper
public interface StockIndexItemConverter {

	StockIndexItemConverter INSTANCE = Mappers.getMapper(StockIndexItemConverter.class);

	/**
	 * PO 转 PageVO
	 * @param stockIndexItem 指数条目
	 * @return StockIndexItemPageVO 指数条目PageVO
	 */
	StockIndexItemPageVO poToPageVo(StockIndexItem stockIndexItem);

}
