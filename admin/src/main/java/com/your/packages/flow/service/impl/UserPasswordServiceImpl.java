package com.your.packages.flow.service.impl;

import com.your.packages.flow.model.entity.UserPassword;
import com.your.packages.flow.model.vo.UserPasswordPageVO;
import com.your.packages.flow.model.qo.UserPasswordQO;
import com.your.packages.flow.mapper.UserPasswordMapper;
import com.your.packages.flow.service.UserPasswordService;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户密码
 *
 * @author lyloou 2021-09-01 11:05:57
 */
@Service
public class UserPasswordServiceImpl extends ExtendServiceImpl<UserPasswordMapper, UserPassword>
		implements UserPasswordService {

	/**
	 * 根据QueryObeject查询分页数据
	 * @param pageParam 分页参数
	 * @param qo 查询参数对象
	 * @return PageResult<UserPasswordPageVO> 分页数据
	 */
	@Override
	public PageResult<UserPasswordPageVO> queryPage(PageParam pageParam, UserPasswordQO qo) {
		return baseMapper.queryPage(pageParam, qo);
	}

}
