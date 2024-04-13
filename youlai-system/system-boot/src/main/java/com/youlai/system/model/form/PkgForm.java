package com.youlai.system.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Schema(description ="")
@Data
public class PkgForm {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "部门名称")
    private String name;

    @Schema(description = "编码")
    private String code;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "状态(1:正常;0:禁用)")
    private Integer status;

    @Schema(description = "${column.comment}")
    private String pkgType;

    @Schema(description = "${column.comment}")
    private String location;

    @Schema(description = "${column.comment}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;

    @Schema(description = "${column.comment}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toDate;

//    @Schema(description = "逻辑删除标识(1:已删除;0:未删除)")
//    private Integer deleted;
////
//    @Schema(description = "创建时间")
//    private Date createTime;
//
//    @Schema(description = "更新时间")
//    private Date updateTime;

}

