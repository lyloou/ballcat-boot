package com.your.packages.flow.service.impl;

import com.your.packages.flow.model.entity.User;
import com.your.packages.flow.model.vo.UserPageVO;
import com.your.packages.flow.model.qo.UserQO;
import com.your.packages.flow.mapper.UserMapper;
import com.your.packages.flow.service.UserService;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Service
public class UserServiceImpl extends ExtendServiceImpl<UserMapper, User> implements UserService {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult<UserPageVO> 分页数据
    */
    @Override
    public PageResult<UserPageVO> queryPage(PageParam pageParam, UserQO qo) {
        return baseMapper.queryPage(pageParam, qo);
    }

}
