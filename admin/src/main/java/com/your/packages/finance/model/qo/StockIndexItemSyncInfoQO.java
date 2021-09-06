package com.your.packages.finance.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 指数条目同步信息 查询对象
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Data
@ApiModel(value = "指数条目同步信息查询对象")
public class StockIndexItemSyncInfoQO  {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty(value="ID")
	private Integer id;

}