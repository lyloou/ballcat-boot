package com.your.packages.flow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.your.packages.flow.converter.UserConverter;
import com.your.packages.flow.model.entity.User;
import com.your.packages.flow.model.qo.UserQO;
import com.your.packages.flow.model.vo.UserPageVO;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.extend.mybatis.plus.conditions.query.LambdaQueryWrapperX;
import com.hccake.extend.mybatis.plus.mapper.ExtendMapper;
import com.hccake.extend.mybatis.plus.toolkit.WrappersX;

/**
 * 用户
 *
 * @author lyloou 2021-09-01 11:05:58
 */
public interface UserMapper extends ExtendMapper<User> {

    /**
    * 分页查询
    * @param pageParam 分页参数
    * @param qo 查询参数
    * @return PageResult<UserPageVO> VO分页数据
    */
   default PageResult<UserPageVO> queryPage(PageParam pageParam, UserQO qo){
		IPage<User> page = this.prodPage(pageParam);
		LambdaQueryWrapperX<User> wrapper = WrappersX.lambdaQueryX(User.class);
		this.selectPage(page, wrapper);
		IPage<UserPageVO> voPage = page.convert(UserConverter.INSTANCE::poToPageVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
   }
}