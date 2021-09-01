package com.your.packages.flow.model.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户分页视图对象
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Data
@ApiModel(value = "用户分页视图对象")
public class UserPageVO {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private Long id;

	/**
	 * 用户名，可登录的
	 */
	@ApiModelProperty(value = "用户名，可登录的")
	private String name;

	/**
	 * 昵称
	 */
	@ApiModelProperty(value = "昵称")
	private String nickname;

	/**
	 * 电子邮件
	 */
	@ApiModelProperty(value = "电子邮件")
	private String email;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private Long phone;

	/**
	 * 大头贴
	 */
	@ApiModelProperty(value = "大头贴")
	private String avatar;

	/**
	 * 个性签名
	 */
	@ApiModelProperty(value = "个性签名")
	private String personalSignature;

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
	 * 是否已经删除
	 */
	@ApiModelProperty(value = "是否已经删除")
	private Integer isDisabled;

}