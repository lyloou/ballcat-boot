package com.your.packages.flow.service;

import com.your.packages.flow.model.entity.User;
import com.your.packages.flow.model.vo.UserPageVO;
import com.your.packages.flow.model.qo.UserQO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.ExtendService;

/**
 * 用户
 *
 * @author lyloou 2021-09-01 11:05:58
 */
public interface UserService extends ExtendService<User> {

	/**
	 * 根据QueryObeject查询分页数据
	 * @param pageParam 分页参数
	 * @param qo 查询参数对象
	 * @return PageResult&lt;UserPageVO&gt; 分页数据
	 */
	PageResult<UserPageVO> queryPage(PageParam pageParam, UserQO qo);

}