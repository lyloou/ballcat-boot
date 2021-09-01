package com.your.packages.flow.converter;

import com.your.packages.flow.model.entity.UserPassword;
import com.your.packages.flow.model.vo.UserPasswordPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户密码模型转换器
 *
 * @author lyloou 2021-09-01 11:05:57
 */
@Mapper
public interface UserPasswordConverter {

	UserPasswordConverter INSTANCE = Mappers.getMapper(UserPasswordConverter.class);

	/**
	 * PO 转 PageVO
	 * @param userPassword 用户密码
	 * @return UserPasswordPageVO 用户密码PageVO
	 */
	UserPasswordPageVO poToPageVo(UserPassword userPassword);

}
