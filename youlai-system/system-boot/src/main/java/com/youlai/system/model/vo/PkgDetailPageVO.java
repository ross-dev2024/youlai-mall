package com.youlai.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Schema(description = "")
@Data
public class PkgDetailPageVO {
    @Schema(description = "${column.comment}")
    private Long id;

//    @Schema(description = "包裹ID")
//    private Integer pkgId;
//    @TableField(value = "pkg_id", property = "pkg.id")
//    private PkgEntity pkg;

    @Schema(description = "${column.comment}")
    private Integer pkgId;

    @Schema(description = "${column.comment}")
    private String pkgName;

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

    @Schema(description = "逻辑删除标识(0:未删除;1:已删除)")
    private Boolean deleted;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

//    @Schema(description = "更新时间")
//    private Date updateTime;
//
//    @Schema(description = "创建人ID")
//    private Long createBy;
//
//    @Schema(description = "更新人ID")
//    private Long updateBy;

}

