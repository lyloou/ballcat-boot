package com.your.packages.flow.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户密码 查询对象
 *
 * @author lyloou 2021-09-01 11:05:57
 */
@Data
@ApiModel(value = "用户密码查询对象")
public class UserPasswordQO  {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户密码ID
	 */
	@ApiModelProperty(value="用户密码ID")
	private Long id;

}