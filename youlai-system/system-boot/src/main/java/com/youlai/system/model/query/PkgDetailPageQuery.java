package com.youlai.system.model.query;

import com.youlai.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * pkg查询对象
 *
 * @author ross
 * @since
 */
@Schema(description = "pkg查询对象")
@Data
public class PkgDetailPageQuery extends BasePageQuery {

    @Schema(description = "关键字")
    private String keywords;

    @Schema(description = "状态(1->正常；0->禁用)")
    private Integer status;

    @Schema(description = "pkgID")
    private Long pkgId;
}
