package com.your.packages.finance.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.your.packages.finance.converter.StockIndexItemSyncInfoConverter;
import com.your.packages.finance.model.entity.StockIndexItemSyncInfo;
import com.your.packages.finance.model.qo.StockIndexItemSyncInfoQO;
import com.your.packages.finance.model.vo.StockIndexItemSyncInfoPageVO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.conditions.query.LambdaQueryWrapperX;
import com.hccake.extend.mybatis.plus.mapper.ExtendMapper;
import com.hccake.extend.mybatis.plus.toolkit.WrappersX;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 指数条目同步信息
 *
 * @author lyloou 2021-09-06 15:42:31
 */
public interface StockIndexItemSyncInfoMapper extends ExtendMapper<StockIndexItemSyncInfo> {

    /**
    * 分页查询
    * @param pageParam 分页参数
    * @param qo 查询参数
    * @return PageResult<StockIndexItemSyncInfoPageVO> VO分页数据
    */
   default PageResult<StockIndexItemSyncInfoPageVO> queryPage(PageParam pageParam, StockIndexItemSyncInfoQO qo){
		IPage<StockIndexItemSyncInfo> page = this.prodPage(pageParam);
		LambdaQueryWrapperX<StockIndexItemSyncInfo> wrapper = WrappersX.lambdaQueryX(StockIndexItemSyncInfo.class);
		this.selectPage(page, wrapper);
		IPage<StockIndexItemSyncInfoPageVO> voPage = page.convert(StockIndexItemSyncInfoConverter.INSTANCE::poToPageVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
   }

   List<StockIndexItemSyncInfo> listSyncInfo();
}