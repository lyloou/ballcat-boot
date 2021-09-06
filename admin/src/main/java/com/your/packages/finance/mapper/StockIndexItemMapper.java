package com.your.packages.finance.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.your.packages.finance.converter.StockIndexItemConverter;
import com.your.packages.finance.model.entity.StockIndexItem;
import com.your.packages.finance.model.qo.StockIndexItemQO;
import com.your.packages.finance.model.vo.StockIndexItemPageVO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.conditions.query.LambdaQueryWrapperX;
import com.hccake.extend.mybatis.plus.mapper.ExtendMapper;
import com.hccake.extend.mybatis.plus.toolkit.WrappersX;

/**
 * 指数条目
 *
 * @author lyloou 2021-09-06 15:42:31
 */
public interface StockIndexItemMapper extends ExtendMapper<StockIndexItem> {

    /**
    * 分页查询
    * @param pageParam 分页参数
    * @param qo 查询参数
    * @return PageResult<StockIndexItemPageVO> VO分页数据
    */
   default PageResult<StockIndexItemPageVO> queryPage(PageParam pageParam, StockIndexItemQO qo){
		IPage<StockIndexItem> page = this.prodPage(pageParam);
		LambdaQueryWrapperX<StockIndexItem> wrapper = WrappersX.lambdaQueryX(StockIndexItem.class);
		this.selectPage(page, wrapper);
		IPage<StockIndexItemPageVO> voPage = page.convert(StockIndexItemConverter.INSTANCE::poToPageVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
   }
}