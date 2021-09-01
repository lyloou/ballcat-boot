package com.your.packages.flow.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 夫路 查询对象
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Data
@ApiModel(value = "夫路查询对象")
public class FlowQO  {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty(value="ID")
	private Long id;

}