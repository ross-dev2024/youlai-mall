package com.youlai.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.system.model.entity.PkgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门表(SysPkg)表数据库访问层
 *
 * @author wangjw
 * @since 2024-04-08 13:39:51
 */
@Mapper
public interface SysPkgMapper extends BaseMapper<PkgEntity> {

//        /**
//     * 获取用户分页列表
//     *
//     * @param page        分页参数
//     * @param queryParams 查询参数
//     * @return {@link List< PkgPageVO >}
//     */
//    Page<PkgPageVO> getPkgPage(Page<PkgPageVO> page, UserPageQuery queryParams);

}

