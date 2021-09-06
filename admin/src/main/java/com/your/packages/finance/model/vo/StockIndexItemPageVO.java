package com.your.packages.finance.model.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
    import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 指数条目分页视图对象
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Data
@ApiModel(value = "指数条目分页视图对象")
public class StockIndexItemPageVO {
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
    private LocalDateTime date;
    
    /**
     * 开盘
     */
    @ApiModelProperty(value="开盘")
    private Double priceStart;
    
    /**
     * 收盘
     */
    @ApiModelProperty(value="收盘")
    private Double priceStop;
    
    /**
     * 涨跌额
     */
    @ApiModelProperty(value="涨跌额")
    private Double priceBetween;
    
    /**
     * 涨跌幅
     */
    @ApiModelProperty(value="涨跌幅")
    private Double priceBetweenRatio;
    
    /**
     * 最高
     */
    @ApiModelProperty(value="最高")
    private Double priceMax;
    
    /**
     * 最低
     */
    @ApiModelProperty(value="最低")
    private Double priceMin;
    
    /**
     * 成交量(手)
     */
    @ApiModelProperty(value="成交量(手)")
    private Long transactionHands;
    
    /**
     * 成交金额(万)
     */
    @ApiModelProperty(value="成交金额(万)")
    private Double transactionAmount;
    
    /**
     * 换手率
     */
    @ApiModelProperty(value="换手率")
    private Double exchangeRate;
    
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