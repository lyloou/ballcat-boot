package com.your.packages.finance.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 指数条目同步信息
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Data
@TableName("stock_index_item_sync_info")
@ApiModel(value = "指数条目同步信息")
public class StockIndexItemSyncInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value = "ID")
	private Integer id;

	/**
	 * 代号
	 */
	@ApiModelProperty(value = "代号")
	private String code;

	/**
	 * 同步的开始时间
	 */
	@ApiModelProperty(value = "同步的开始时间")
	@JSONField(format = "yyyy-MM-dd")
	private LocalDateTime start;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 查询参数
	 */
	@ApiModelProperty(value = "查询参数")
	private String queryParam;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateTime;


}
