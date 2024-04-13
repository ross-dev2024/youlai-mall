package com.youlai.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.common.result.PageResult;
import com.youlai.common.result.Result;
import com.youlai.system.model.form.PkgForm;
import com.youlai.system.model.query.PkgPageQuery;
import com.youlai.system.model.vo.PkgPageVO;
import com.youlai.system.service.SysPkgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

/**
 * 部门表(SysPkg)表控制层
 *
 * @author wangjw
 * @since 2024-04-08 14:23:28
 */
@Tag(name = "")
@RestController
@RequestMapping("/api/v1/pkg")
@RequiredArgsConstructor
public class SysPkgController  {

    /**
     * サービスオブジェクト
     */
    private final SysPkgService service;

    @Operation(summary = "分页列表")
    @GetMapping("/page")
    public PageResult<PkgPageVO> getPage(
            @ParameterObject PkgPageQuery queryParams) {
        IPage<PkgPageVO> result = service.getPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增pkg")
    @PostMapping
//    @PreAuthorize("@ss.hasPerm('sys:role:add')")
//    @PreventDuplicateResubmit
    public Result create(@Valid @RequestBody PkgForm form) {
        boolean result = service.savePkg(form);
        return Result.judge(result);
    }


    @Operation(summary = "修改pkg")
    @PutMapping(value = "/{pkgId}")
//    @PreAuthorize("@ss.hasPerm('sys:role:edit')")
    public Result update(@Valid @RequestBody PkgForm form) {
        boolean result = service.savePkg(form);
        return Result.judge(result);
    }

    @Operation(summary = "删除pkg")
    @DeleteMapping("/{ids}")
//    @PreAuthorize("@ss.hasPerm('sys:ropwdle:delete')")
    public Result deletes(
            @Parameter(description ="删除，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = service.deletePkgs(ids);
        return Result.judge(result);
    }

    @Operation(summary = "修改pkg状态")
    @PutMapping(value = "/{pkgId}/status")
    public Result updateStatus(
            @Parameter(description ="ID") @PathVariable Long pkgId,
            @Parameter(description ="状态(1:启用;0:禁用)") @RequestParam Integer status
    ) {
        boolean result = service.updatePkgStatus(pkgId, status);
        return Result.judge(result);
    }

}

