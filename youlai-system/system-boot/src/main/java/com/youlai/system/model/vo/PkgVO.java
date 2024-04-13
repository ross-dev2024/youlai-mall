package com.youlai.system.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
@Schema(description ="")
@Data
public class PkgVO  {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "部门名称")
    private String name;

    @Schema(description = "编码")
    private String code;

    @Schema(description = "父节点id")
    private Long parentId;

    @Schema(description = "父节点id路径")
    private String treePath;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "状态(1:正常;0:禁用)")
    private Integer status;

    @Schema(description = "package種類")
    private String pkgType;

    @Schema(description = "場所")
    private String location;

    @Schema(description = "送付時間")
    private Date sendDate;

    @Schema(description = "到着時間")
    private Date toDate;

    @Schema(description = "逻辑删除标识(1:已删除;0:未删除)")
    private Integer deleted;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

}

