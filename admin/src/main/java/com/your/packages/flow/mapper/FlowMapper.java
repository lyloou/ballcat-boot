package com.your.packages.flow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.your.packages.flow.converter.FlowConverter;
import com.your.packages.flow.model.entity.Flow;
import com.your.packages.flow.model.qo.FlowQO;
import com.your.packages.flow.model.vo.FlowPageVO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.conditions.query.LambdaQueryWrapperX;
import com.hccake.extend.mybatis.plus.mapper.ExtendMapper;
import com.hccake.extend.mybatis.plus.toolkit.WrappersX;

/**
 * 夫路
 *
 * @author lyloou 2021-09-01 11:05:58
 */
public interface FlowMapper extends ExtendMapper<Flow> {

    /**
    * 分页查询
    * @param pageParam 分页参数
    * @param qo 查询参数
    * @return PageResult<FlowPageVO> VO分页数据
    */
   default PageResult<FlowPageVO> queryPage(PageParam pageParam, FlowQO qo){
		IPage<Flow> page = this.prodPage(pageParam);
		LambdaQueryWrapperX<Flow> wrapper = WrappersX.lambdaQueryX(Flow.class)
				.eqIfPresent(Flow::getId, qo.getId());
		this.selectPage(page, wrapper);
		IPage<FlowPageVO> voPage = page.convert(FlowConverter.INSTANCE::poToPageVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
   }
}