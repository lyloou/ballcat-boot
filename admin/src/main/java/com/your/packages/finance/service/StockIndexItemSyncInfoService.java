package com.your.packages.finance.service;

import com.your.packages.finance.model.entity.StockIndexItemSyncInfo;
import com.your.packages.finance.model.vo.StockIndexItemSyncInfoPageVO;
import com.your.packages.finance.model.qo.StockIndexItemSyncInfoQO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.ExtendService;

import java.util.List;

/**
 * 指数条目同步信息
 *
 * @author lyloou 2021-09-06 15:42:31
 */
public interface StockIndexItemSyncInfoService extends ExtendService<StockIndexItemSyncInfo> {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult&lt;StockIndexItemSyncInfoPageVO&gt; 分页数据
    */
    PageResult<StockIndexItemSyncInfoPageVO> queryPage(PageParam pageParam, StockIndexItemSyncInfoQO qo);

}