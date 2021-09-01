package com.your.packages.flow.service;

import com.your.packages.flow.model.entity.UserPassword;
import com.your.packages.flow.model.vo.UserPasswordPageVO;
import com.your.packages.flow.model.qo.UserPasswordQO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.ExtendService;

/**
 * 用户密码
 *
 * @author lyloou 2021-09-01 11:05:57
 */
public interface UserPasswordService extends ExtendService<UserPassword> {

    /**
    *  根据QueryObeject查询分页数据
    * @param pageParam 分页参数
    * @param qo 查询参数对象
    * @return PageResult&lt;UserPasswordPageVO&gt; 分页数据
    */
    PageResult<UserPasswordPageVO> queryPage(PageParam pageParam, UserPasswordQO qo);

}