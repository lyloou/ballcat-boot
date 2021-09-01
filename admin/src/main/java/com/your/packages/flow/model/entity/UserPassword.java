package com.your.packages.flow.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户密码
 *
 * @author lyloou 2021-09-01 11:05:57
 */
@Data
@TableName("user_password")
@ApiModel(value = "用户密码")
public class UserPassword {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户密码ID
	 */
	@TableId
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
