package com.youlai.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.system.model.entity.PkgEntity;
import com.youlai.system.model.form.PkgForm;
import com.youlai.system.model.vo.PkgPageVO;
import org.mapstruct.Mapper;

/**
 * 部门对象转换器
 *
 * @author ross
 * @since 2022/7/29
 */
@Mapper(componentModel = "spring")
public interface PkgConverter {

    // entity2Page
    Page<PkgPageVO> entity2Page(Page<PkgEntity> page);

    PkgForm entity2Form(PkgEntity entity);
//    DeptVO entity2Vo(SysDept entity);
//
    PkgEntity form2Entity(PkgForm form);
}