package com.your.packages.flow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.your.packages.flow.converter.UserPasswordConverter;
import com.your.packages.flow.model.entity.UserPassword;
import com.your.packages.flow.model.qo.UserPasswordQO;
import com.your.packages.flow.model.vo.UserPasswordPageVO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.conditions.query.LambdaQueryWrapperX;
import com.hccake.extend.mybatis.plus.mapper.ExtendMapper;
import com.hccake.extend.mybatis.plus.toolkit.WrappersX;

/**
 * 用户密码
 *
 * @author lyloou 2021-09-01 11:05:57
 */
public interface UserPasswordMapper extends ExtendMapper<UserPassword> {

	/**
	 * 分页查询
	 * @param pageParam 分页参数
	 * @param qo 查询参数
	 * @return PageResult<UserPasswordPageVO> VO分页数据
	 */
	default PageResult<UserPasswordPageVO> queryPage(PageParam pageParam, UserPasswordQO qo) {
		IPage<UserPassword> page = this.prodPage(pageParam);
		LambdaQueryWrapperX<UserPassword> wrapper = WrappersX.lambdaQueryX(UserPassword.class);
		this.selectPage(page, wrapper);
		IPage<UserPasswordPageVO> voPage = page.convert(UserPasswordConverter.INSTANCE::poToPageVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
	}

}