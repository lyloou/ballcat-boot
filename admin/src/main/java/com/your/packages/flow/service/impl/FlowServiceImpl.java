package com.your.packages.flow.service.impl;

import com.your.packages.flow.model.entity.Flow;
import com.your.packages.flow.model.vo.FlowPageVO;
import com.your.packages.flow.model.qo.FlowQO;
import com.your.packages.flow.mapper.FlowMapper;
import com.your.packages.flow.service.FlowService;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 夫路
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Service
public class FlowServiceImpl extends ExtendServiceImpl<FlowMapper, Flow> implements FlowService {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult<FlowPageVO> 分页数据
    */
    @Override
    public PageResult<FlowPageVO> queryPage(PageParam pageParam, FlowQO qo) {
        return baseMapper.queryPage(pageParam, qo);
    }

}
