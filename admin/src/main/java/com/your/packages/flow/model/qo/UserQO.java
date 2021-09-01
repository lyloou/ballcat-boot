package com.your.packages.flow.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户 查询对象
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Data
@ApiModel(value = "用户查询对象")
public class UserQO {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private Long id;

}