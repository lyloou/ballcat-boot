package com.your.packages.flow.converter;

import com.your.packages.flow.model.entity.Flow;
import com.your.packages.flow.model.vo.FlowPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 夫路模型转换器
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Mapper
public interface FlowConverter {

	FlowConverter INSTANCE = Mappers.getMapper(FlowConverter.class);

	/**
	 * PO 转 PageVO
	 * @param flow 夫路
	 * @return FlowPageVO 夫路PageVO
	 */
	FlowPageVO poToPageVo(Flow flow);

}
