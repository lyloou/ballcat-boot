package com.your.packages.flow.controller;

import com.your.packages.flow.model.entity.UserPassword;
import com.your.packages.flow.model.qo.UserPasswordQO;
import com.your.packages.flow.model.vo.UserPasswordPageVO;
import com.your.packages.flow.service.UserPasswordService;
import com.hccake.ballcat.common.log.operation.annotation.CreateOperationLogging;
import com.hccake.ballcat.common.log.operation.annotation.DeleteOperationLogging;
import com.hccake.ballcat.common.log.operation.annotation.UpdateOperationLogging;
import com.hccake.ballcat.common.model.domain.PageParam;
import com.hccake.ballcat.common.model.domain.PageResult;
import com.hccake.ballcat.common.model.result.BaseResultCode;
import com.hccake.ballcat.common.model.result.R;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户密码
 *
 * @author lyloou 2021-09-01 11:05:57
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/flow/user-password")
@Api(value = "user-password", tags = "用户密码管理")
public class UserPasswordController {

	private final UserPasswordService userPasswordService;

	/**
	 * 分页查询
	 * @param pageParam 分页参数
	 * @param userPasswordQO 用户密码查询对象
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@per.hasPermission('flow:user-password:read')")
	public R<PageResult<UserPasswordPageVO>> getUserPasswordPage(PageParam pageParam, UserPasswordQO userPasswordQO) {
		return R.ok(userPasswordService.queryPage(pageParam, userPasswordQO));
	}

	/**
	 * 新增用户密码
	 * @param userPassword 用户密码
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "新增用户密码", notes = "新增用户密码")
	@CreateOperationLogging(msg = "新增用户密码")
	@PostMapping
	@PreAuthorize("@per.hasPermission('flow:user-password:add')")
	public R save(@RequestBody UserPassword userPassword) {
		return userPasswordService.save(userPassword) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增用户密码失败");
	}

	/**
	 * 修改用户密码
	 * @param userPassword 用户密码
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "修改用户密码", notes = "修改用户密码")
	@UpdateOperationLogging(msg = "修改用户密码")
	@PutMapping
	@PreAuthorize("@per.hasPermission('flow:user-password:edit')")
	public R updateById(@RequestBody UserPassword userPassword) {
		return userPasswordService.updateById(userPassword) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改用户密码失败");
	}

	/**
	 * 通过id删除用户密码
	 * @param id id
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "通过id删除用户密码", notes = "通过id删除用户密码")
	@DeleteOperationLogging(msg = "通过id删除用户密码")
	@DeleteMapping("/{id}")
	@PreAuthorize("@per.hasPermission('flow:user-password:del')")
	public R removeById(@PathVariable("id") Long id) {

		return userPasswordService.removeById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除用户密码失败");
	}

}