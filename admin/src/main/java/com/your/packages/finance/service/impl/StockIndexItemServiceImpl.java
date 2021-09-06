package com.your.packages.finance.service.impl;

import com.your.packages.finance.model.entity.StockIndexItem;
import com.your.packages.finance.model.vo.StockIndexItemPageVO;
import com.your.packages.finance.model.qo.StockIndexItemQO;
import com.your.packages.finance.mapper.StockIndexItemMapper;
import com.your.packages.finance.service.StockIndexItemService;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 指数条目
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@Service
public class StockIndexItemServiceImpl extends ExtendServiceImpl<StockIndexItemMapper, StockIndexItem> implements StockIndexItemService {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult<StockIndexItemPageVO> 分页数据
    */
    @Override
    public PageResult<StockIndexItemPageVO> queryPage(PageParam pageParam, StockIndexItemQO qo) {
        return baseMapper.queryPage(pageParam, qo);
    }

}
