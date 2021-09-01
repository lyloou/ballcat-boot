package com.your.packages.flow.controller;

import com.your.packages.flow.model.entity.User;
import com.your.packages.flow.model.qo.UserQO;
import com.your.packages.flow.model.vo.UserPageVO;
import com.your.packages.flow.service.UserService;
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
 * 用户
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/flow/user" )
@Api(value = "user", tags = "用户管理")
public class UserController {

    private final  UserService userService;

    /**
     * 分页查询
     * @param pageParam 分页参数
     * @param userQO 用户查询对象
     * @return R 通用返回体
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@per.hasPermission('flow:user:read')" )
    public R<PageResult<UserPageVO>> getUserPage(
            PageParam pageParam, UserQO userQO) {
        return R.ok(userService.queryPage(pageParam, userQO));
    }

    /**
     * 新增用户
     * @param user 用户
     * @return R 通用返回体
     */
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @CreateOperationLogging(msg = "新增用户" )
    @PostMapping
    @PreAuthorize("@per.hasPermission('flow:user:add')" )
    public R save(@RequestBody User user) {
        return userService.save(user) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增用户失败");
    }

    /**
     * 修改用户
     * @param user 用户
     * @return R 通用返回体
     */
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @UpdateOperationLogging(msg = "修改用户" )
    @PutMapping
    @PreAuthorize("@per.hasPermission('flow:user:edit')" )
    public R updateById(@RequestBody User user) {
        return userService.updateById(user) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改用户失败");
    }

    /**
     * 通过id删除用户
     * @param id id
     * @return R 通用返回体
     */
    @ApiOperation(value = "通过id删除用户", notes = "通过id删除用户")
    @DeleteOperationLogging(msg = "通过id删除用户" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@per.hasPermission('flow:user:del')" )
    public R removeById(@PathVariable("id") Long id) {
        return userService.removeById(id) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除用户失败");
    }

}