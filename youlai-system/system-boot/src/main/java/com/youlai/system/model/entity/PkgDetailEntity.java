package com.youlai.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.common.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
/**
 * 用户信息表(SysPkgDetail)表实体类
 *
 * @author wangjw
 * @since 2024-04-13 19:18:31
 */
@Data
@TableName(value = "sys_pkg_detail")
public class PkgDetailEntity  extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
//
//    /**
//     * 包裹ID
//     */
//    @TableField(value = "pkg_id")
//    private Integer pkgId;
    @TableField(value = "pkg_id", property = "pkg.id")
    private PkgEntity pkg;

    @TableField(value = "item_id")
    private Integer itemId;

    /**
     * 品物名
     */
    @TableField(value = "item_name")
    private String itemName;

    @TableField(value = "item_price")
    private BigDecimal itemPrice;

    /**
     * 所属用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 联系方式
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 状态((1:正常;0:禁用))
     */
    @TableField(value = "status")
    private Boolean status;

    /**
     * 注释
     */
    @TableField(value = "comment")
    private String comment;

    /**
     * 逻辑删除标识(0:未删除;1:已删除)
     */
    @TableField(value = "deleted")
    private Boolean deleted;
//
//    /**
//     * 创建时间
//     */
//    @TableField(value = "create_time")
//    private Date createTime;
//
//    /**
//     * 更新时间
//     */
//    @TableField(value = "update_time")
//    private Date updateTime;

    /**
     * 创建人ID
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 更新人ID
     */
    @TableField(value = "update_by")
    private Long updateBy;




}

