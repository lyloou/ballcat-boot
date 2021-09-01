package com.your.packages.flow.controller;

import com.your.packages.flow.model.entity.Flow;
import com.your.packages.flow.model.qo.FlowQO;
import com.your.packages.flow.model.vo.FlowPageVO;
import com.your.packages.flow.service.FlowService;
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
 * 夫路
 *
 * @author lyloou 2021-09-01 11:05:58
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/flow/flow")
@Api(value = "flow", tags = "夫路管理")
public class FlowController {

	private final FlowService flowService;

	/**
	 * 分页查询
	 * @param pageParam 分页参数
	 * @param flowQO 夫路查询对象
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@per.hasPermission('flow:flow:read')")
	public R<PageResult<FlowPageVO>> getFlowPage(PageParam pageParam, FlowQO flowQO) {
		return R.ok(flowService.queryPage(pageParam, flowQO));
	}

	/**
	 * 新增夫路
	 * @param flow 夫路
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "新增夫路", notes = "新增夫路")
	@CreateOperationLogging(msg = "新增夫路")
	@PostMapping
	@PreAuthorize("@per.hasPermission('flow:flow:add')")
	public R save(@RequestBody Flow flow) {
		return flowService.save(flow) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增夫路失败");
	}

	/**
	 * 修改夫路
	 * @param flow 夫路
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "修改夫路", notes = "修改夫路")
	@UpdateOperationLogging(msg = "修改夫路")
	@PutMapping
	@PreAuthorize("@per.hasPermission('flow:flow:edit')")
	public R updateById(@RequestBody Flow flow) {
		return flowService.updateById(flow) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改夫路失败");
	}

	/**
	 * 通过id删除夫路
	 * @param id id
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "通过id删除夫路", notes = "通过id删除夫路")
	@DeleteOperationLogging(msg = "通过id删除夫路")
	@DeleteMapping("/{id}")
	@PreAuthorize("@per.hasPermission('flow:flow:del')")
	public R removeById(@PathVariable("id") Long id) {
		return flowService.removeById(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除夫路失败");
	}

}