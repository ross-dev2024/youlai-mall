package com.youlai.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.common.result.PageResult;
import com.youlai.common.result.Result;
import com.youlai.common.web.model.Option;
import com.youlai.system.model.form.PkgDetailForm;
import com.youlai.system.model.form.PkgForm;
import com.youlai.system.model.query.PkgDetailPageQuery;
import com.youlai.system.model.query.PkgPageQuery;
import com.youlai.system.model.vo.PkgDetailPageVO;
import com.youlai.system.model.vo.PkgPageVO;
import com.youlai.system.service.SysPkgDetailService;
import com.youlai.system.service.SysPkgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SysPkgController
 *
 * @author wangjw
 * @since 2024-04-08 14:23:28
 */
@Tag(name = "")
@RestController
@RequestMapping("/api/v1/pkg")
@RequiredArgsConstructor
public class SysPkgController {

    /**
     * サービスオブジェクト
     */
    private final SysPkgService pkgService;

    /**
     * サービスオブジェクト
     */
    private final SysPkgDetailService detailService;

    @Operation(summary = "分页列表")
    @GetMapping("/page")
    public PageResult<PkgPageVO> getPage(
            @ParameterObject PkgPageQuery queryParams) {
        IPage<PkgPageVO> result = pkgService.getPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "获取下拉选项")
    @GetMapping("/options")
    public Result<List<Option>> listPkgOptions() {
        List<Option> list = pkgService.listPkgOptions();
        return Result.success(list);
    }

    @Operation(summary = "新增pkg")
    @PostMapping
//    @PreAuthorize("@ss.hasPerm('sys:role:add')")
//    @PreventDuplicateResubmit
    public Result create(@Valid @RequestBody PkgForm form) {
        boolean result = pkgService.savePkg(form);
        return Result.judge(result);
    }


    @Operation(summary = "修改pkg")
    @PutMapping(value = "/{pkgId}")
//    @PreAuthorize("@ss.hasPerm('sys:role:edit')")
    public Result update(@Valid @RequestBody PkgForm form) {
        boolean result = pkgService.savePkg(form);
        return Result.judge(result);
    }

    @Operation(summary = "删除pkg")
    @DeleteMapping("/{ids}")
//    @PreAuthorize("@ss.hasPerm('sys:ropwdle:delete')")
    public Result deletes(
            @Parameter(description = "删除，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pkgService.deletePkgs(ids);
        return Result.judge(result);
    }

    @Operation(summary = "修改pkg状态")
    @PutMapping(value = "/{pkgId}/status")
    public Result updateStatus(
            @Parameter(description = "ID") @PathVariable Long pkgId,
            @Parameter(description = "状态(1:启用;0:禁用)") @RequestParam Integer status
    ) {
        boolean result = pkgService.updatePkgStatus(pkgId, status);
        return Result.judge(result);
    }

    @Operation(summary = "分页列表")
    @GetMapping("/detail/pages")
    public PageResult<PkgDetailPageVO> getPage(
            @ParameterObject PkgDetailPageQuery queryParams) {
        // 查询参数
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        String keywords = queryParams.getKeywords();
        IPage<PkgDetailPageVO> result = detailService.selectPkgDetailPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增item")
    @PostMapping("/detail")
//    @PreAuthorize("@ss.hasPerm('sys:role:add')")
//    @PreventDuplicateResubmit
    public Result createDetail(@Valid @RequestBody PkgDetailForm form) {
        boolean result = detailService.createOrUpdate(null, form);
        return Result.judge(result);
    }

    @Operation(summary = "item取得")
    @GetMapping("/detail/{id}/form")
//    @PreAuthorize("@ss.hasPerm('sys:role:add')")
//    @PreventDuplicateResubmit
    public Result getDetail(
            @Parameter(description = "itemID") @PathVariable Long id) {
        PkgDetailForm formData = detailService.getItem(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改item")
    @PutMapping(value = "/detail/{id}")
//    @PreAuthorize("@ss.hasPerm('sys:role:edit')")
    public Result updateDetail(
            @PathVariable Long id,
            @Valid @RequestBody PkgDetailForm form) {
        boolean result = detailService.createOrUpdate(id, form);
        return Result.judge(result);
    }

    @Operation(summary = "删除item")
    @DeleteMapping("/detail/{ids}")
//    @PreAuthorize("@ss.hasPerm('sys:ropwdle:delete')")
    public Result deleteDetail(
            @Parameter(description = "删除，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = detailService.delete(ids);
        return Result.judge(result);
    }
}

