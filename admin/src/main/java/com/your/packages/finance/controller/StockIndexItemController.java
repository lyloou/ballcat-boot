package com.your.packages.finance.controller;

import com.your.packages.finance.model.entity.StockIndexItem;
import com.your.packages.finance.model.qo.StockIndexItemQO;
import com.your.packages.finance.model.vo.StockIndexItemPageVO;
import com.your.packages.finance.service.StockIndexItemService;
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
 * 指数条目
 *
 * @author lyloou 2021-09-06 15:42:31
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/finance/stock-index-item" )
@Api(value = "stock-index-item", tags = "指数条目管理")
public class StockIndexItemController {

    private final  StockIndexItemService stockIndexItemService;

    /**
     * 分页查询
     * @param pageParam 分页参数
     * @param stockIndexItemQO 指数条目查询对象
     * @return R 通用返回体
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@per.hasPermission('finance:stock-index-item:read')" )
    public R<PageResult<StockIndexItemPageVO>> getStockIndexItemPage(
            PageParam pageParam, StockIndexItemQO stockIndexItemQO) {
        return R.ok(stockIndexItemService.queryPage(pageParam, stockIndexItemQO));
    }

    /**
     * 新增指数条目
     * @param stockIndexItem 指数条目
     * @return R 通用返回体
     */
    @ApiOperation(value = "新增指数条目", notes = "新增指数条目")
    @CreateOperationLogging(msg = "新增指数条目" )
    @PostMapping
    @PreAuthorize("@per.hasPermission('finance:stock-index-item:add')" )
    public R save(@RequestBody StockIndexItem stockIndexItem) {
        return stockIndexItemService.save(stockIndexItem) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增指数条目失败");
    }

    /**
     * 修改指数条目
     * @param stockIndexItem 指数条目
     * @return R 通用返回体
     */
    @ApiOperation(value = "修改指数条目", notes = "修改指数条目")
    @UpdateOperationLogging(msg = "修改指数条目" )
    @PutMapping
    @PreAuthorize("@per.hasPermission('finance:stock-index-item:edit')" )
    public R updateById(@RequestBody StockIndexItem stockIndexItem) {
        return stockIndexItemService.updateById(stockIndexItem) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改指数条目失败");
    }

    /**
     * 通过id删除指数条目
     * @param id id
     * @return R 通用返回体
     */
    @ApiOperation(value = "通过id删除指数条目", notes = "通过id删除指数条目")
    @DeleteOperationLogging(msg = "通过id删除指数条目" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@per.hasPermission('finance:stock-index-item:del')" )
    public R removeById(@PathVariable("id") Integer id) {
        return stockIndexItemService.removeById(id) ?
                R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除指数条目失败");
    }

}