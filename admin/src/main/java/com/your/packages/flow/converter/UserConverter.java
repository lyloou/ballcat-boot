package com.your.packages.flow.converter;

import com.your.packages.flow.model.entity.User;
import com.your.packages.flow.model.vo.UserPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户模型转换器
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@Mapper
public interface UserConverter {

	UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

	/**
	 * PO 转 PageVO
	 * @param user 用户
	 * @return UserPageVO 用户PageVO
	 */
	UserPageVO poToPageVo(User user);

}
