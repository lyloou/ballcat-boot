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
 * 夫路
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Data
@TableName("flow")
@ApiModel(value = "夫路")
public class Flow {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value = "ID")
	private Long id;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private Long userId;

	/**
	 * 哪一天
	 */
	@ApiModelProperty(value = "哪一天")
	private String day;

	/**
	 * 发生的哪些具体事情
	 */
	@ApiModelProperty(value = "发生的哪些具体事情")
	private String item;

	/**
	 * 天气情况
	 */
	@ApiModelProperty(value = "天气情况")
	private String weather;

	/**
	 * 备忘
	 */
	@ApiModelProperty(value = "备忘")
	private String memo;

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
	 * 是否已经存档
	 */
	@ApiModelProperty(value = "是否已经存档")
	private Integer isArchived;

	/**
	 * 是否已经删除
	 */
	@ApiModelProperty(value = "是否已经删除")
	private Integer isDisabled;

	/**
	 * 同步es的状态: 0未同步，1成功，2失败
	 */
	@ApiModelProperty(value = "同步es的状态: 0未同步，1成功，2失败")
	private Integer syncEsStatus;

}
