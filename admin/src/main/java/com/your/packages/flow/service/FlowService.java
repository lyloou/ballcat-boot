package com.your.packages.flow.service;

import com.your.packages.flow.model.entity.Flow;
import com.your.packages.flow.model.vo.FlowPageVO;
import com.your.packages.flow.model.qo.FlowQO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.ExtendService;

/**
 * 夫路
 *
 * @author lyloou 2021-09-01 11:05:58
 */
public interface FlowService extends ExtendService<Flow> {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult&lt;FlowPageVO&gt; 分页数据
    */
    PageResult<FlowPageVO> queryPage(PageParam pageParam, FlowQO qo);

}