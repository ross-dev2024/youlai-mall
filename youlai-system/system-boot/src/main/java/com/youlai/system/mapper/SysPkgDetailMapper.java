package com.youlai.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.system.model.entity.PkgDetailEntity;
import com.youlai.system.model.query.PkgDetailPageQuery;
import com.youlai.system.model.vo.PkgDetailPageVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表(SysPkgDetail)表数据库访问层
 *
 * @author ross.dev
 * @since 2024-04-15 11:23:50
 */
@Mapper
public interface SysPkgDetailMapper extends BaseMapper<PkgDetailEntity> {

//    /**
//    * 批量新增数据（MyBatis原生foreach方法）
//    *
//    * @param entities List<PkgDetailEntity> 实例对象列表
//    * @return 影响行数
//    */
//    int insertBatch(@Param("entities") List<PkgDetailEntity> entities);
//
//    /**
//    * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//    *
//    * @param entities List<PkgDetailEntity> 实例对象列表
//    * @return 影响行数
//    * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
//    */
//    int insertOrUpdateBatch(@Param("entities") List<PkgDetailEntity> entities);


    Page<PkgDetailPageVO> selectPkgDetailPage(IPage<PkgDetailPageVO> page, PkgDetailPageQuery queryParams);

}

