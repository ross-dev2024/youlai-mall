package com.youlai.system.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description ="")
@Data
public class PkgDetailForm {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "包裹ID")
    private Integer pkgId;

//    @Schema(description = "包裹名")
//    private String pkgName;

    @Schema(description = "${column.comment}")
    private Integer itemId;

    @Schema(description = "品物名")
    private String itemName;

    @Schema(description = "${column.comment}")
    private BigDecimal itemPrice;

    @Schema(description = "所属用户名")
    private String username;

    @Schema(description = "联系方式")
    private String mobile;

    @Schema(description = "状态((1:正常;0:禁用))")
    private Integer status;

    @Schema(description = "注释")
    private String comment;

//    @Schema(description = "逻辑删除标识(1:已删除;0:未删除)")
//    private Integer deleted;
////
//    @Schema(description = "创建时间")
//    private Date createTime;
//
//    @Schema(description = "更新时间")
//    private Date updateTime;

}

