package com.youlai.system.model.query;

import com.youlai.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * pdg查询对象
 *
 * @author ross
 * @since
 */
@Schema(description ="pdg查询对象")
@Data
public class PkgPageQuery extends BasePageQuery {

    @Schema(description="关键字(包裹名称)")
    private String keywords;

    @Schema(description="状态(1->正常；0->禁用)")
    private Integer status;

}
