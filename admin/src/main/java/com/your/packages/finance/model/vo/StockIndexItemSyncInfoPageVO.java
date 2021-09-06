package com.your.packages.finance.model.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
    import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 指数条目同步信息分页视图对象
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Data
@ApiModel(value = "指数条目同步信息分页视图对象")
public class StockIndexItemSyncInfoPageVO {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value="ID")
    private Integer id;
    
    /**
     * 代号
     */
    @ApiModelProperty(value="代号")
    private String code;
    
    /**
     * 同步的开始时间
     */
    @ApiModelProperty(value="同步的开始时间")
    private Integer start;
    
    /**
     * 同步的结束时间
     */
    @ApiModelProperty(value="同步的结束时间")
    private Integer end;
    
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;
    
    /**
     * 查询参数
     */
    @ApiModelProperty(value="查询参数")
    private String queryParam;
    
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;
    
    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;
    

}