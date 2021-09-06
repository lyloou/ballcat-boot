package com.your.packages.finance.service;

import com.your.packages.finance.model.entity.StockIndexItem;
import com.your.packages.finance.model.vo.StockIndexItemPageVO;
import com.your.packages.finance.model.qo.StockIndexItemQO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.ExtendService;

/**
 * 指数条目
 *
 * @author lyloou 2021-09-06 15:42:31
 */
public interface StockIndexItemService extends ExtendService<StockIndexItem> {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult&lt;StockIndexItemPageVO&gt; 分页数据
    */
    PageResult<StockIndexItemPageVO> queryPage(PageParam pageParam, StockIndexItemQO qo);

}