package com.your.packages.flow.model.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户密码分页视图对象
 *
 * @author lyloou 2021-09-01 11:05:57
 */
@Data
@ApiModel(value = "用户密码分页视图对象")
public class UserPasswordPageVO {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户密码ID
	 */
	@ApiModelProperty(value = "用户密码ID")
	private Long id;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private LocalDateTime gmtModified;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private Long userId;

	/**
	 * 用户登录名
	 */
	@ApiModelProperty(value = "用户登录名")
	private String name;

	/**
	 * 用户登录密码
	 */
	@ApiModelProperty(value = "用户登录密码")
	private String password;

}