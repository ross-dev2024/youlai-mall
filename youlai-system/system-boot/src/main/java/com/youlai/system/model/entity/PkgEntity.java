package com.youlai.system.model.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;
/**
 * 部门表(SysPkg)表实体类
 *
 * @author wangjw
 * @since 2024-04-11 10:02:38
 */
@Data
@TableName(value = "sys_pkg")
public class PkgEntity  extends BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 编码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 父节点id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 父节点id路径
     */
    @TableField(value = "tree_path")
    private String treePath;

    /**
     * 显示顺序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态(1:正常;0:禁用)
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * package種類
     */
    @TableField(value = "pkg_type")
    private String pkgType;

    /**
     * 場所
     */
    @TableField(value = "location")
    private String location;

    /**
     * 送付時間
     */
    @TableField(value = "send_date")
    private Date sendDate;

    /**
     * 到着時間
     */
    @TableField(value = "to_date")
    private Date toDate;

    /**
     * 逻辑删除标识(1:已删除;0:未删除)
     */
    @TableField(value = "deleted")
    private Integer deleted;

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




}

