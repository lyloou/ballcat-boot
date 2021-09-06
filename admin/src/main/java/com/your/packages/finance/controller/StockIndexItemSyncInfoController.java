package com.your.packages.finance.controller;

import com.your.packages.finance.model.entity.StockIndexItemSyncInfo;
import com.your.packages.finance.model.qo.StockIndexItemSyncInfoQO;
import com.your.packages.finance.model.vo.StockIndexItemSyncInfoPageVO;
import com.your.packages.finance.service.StockIndexItemSyncInfoService;
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
 * 指数条目同步信息
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/finance/stock-index-item-sync-info" )
@Api(value = "stock-index-item-sync-info", tags = "指数条目同步信息管理")
public class StockIndexItemSyncInfoController {

    private final  StockIndexItemSyncInfoService stockIndexItemSyncInfoService;

    /**
     * 分页查询
     * @param pageParam 分页参数
     * @param stockIndexItemSyncInfoQO 指数条目同步信息查询对象
     * @return R 通用返回体
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@per.hasPermission('finance:stock-index-item-sync-info:read')" )
    public R<PageResult<StockIndexItemSyncInfoPageVO>> getStockIndexItemSyncInfoPage(
            PageParam pageParam, StockIndexItemSyncInfoQO stockIndexItemSyncInfoQO) {
        return R.ok(stockIndexItemSyncInfoService.queryPage(pageParam, stockIndexItemSyncInfoQO));
    }

    /**
     * 新增指数条目同步信息
     * @param stockIndexItemSyncInfo 指数条目同步信息
     * @return R 通用返回体
     */
    @ApiOperation(value = "新增指数条目同步信息", notes = "新增指数条目同步信息")
    @CreateOperationLogging(msg = "新增指数条目同步信息" )
    @PostMapping
    @PreAuthorize("@per.hasPermission('finance:stock-index-item-sync-info:add')" )
    public R save(@RequestBody StockIndexItemSyncInfo stockIndexItemSyncInfo) {
        return stockIndexItemSyncInfoService.save(stockIndexItemSyncInfo) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增指数条目同步信息失败");
    }

    /**
     * 修改指数条目同步信息
     * @param stockIndexItemSyncInfo 指数条目同步信息
     * @return R 通用返回体
     */
    @ApiOperation(value = "修改指数条目同步信息", notes = "修改指数条目同步信息")
    @UpdateOperationLogging(msg = "修改指数条目同步信息" )
    @PutMapping
    @PreAuthorize("@per.hasPermission('finance:stock-index-item-sync-info:edit')" )
    public R updateById(@RequestBody StockIndexItemSyncInfo stockIndexItemSyncInfo) {
        return stockIndexItemSyncInfoService.updateById(stockIndexItemSyncInfo) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改指数条目同步信息失败");
    }

    /**
     * 通过id删除指数条目同步信息
     * @param id id
     * @return R 通用返回体
     */
    @ApiOperation(value = "通过id删除指数条目同步信息", notes = "通过id删除指数条目同步信息")
    @DeleteOperationLogging(msg = "通过id删除指数条目同步信息" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@per.hasPermission('finance:stock-index-item-sync-info:del')" )
    public R removeById(@PathVariable("id") Integer id) {
        return stockIndexItemSyncInfoService.removeById(id) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除指数条目同步信息失败");
    }

}