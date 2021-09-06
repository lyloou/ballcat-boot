package com.your.packages.finance.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 指数条目 查询对象
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Data
@ApiModel(value = "指数条目查询对象")
public class StockIndexItemQO  {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty(value="ID")
	private Integer id;

}