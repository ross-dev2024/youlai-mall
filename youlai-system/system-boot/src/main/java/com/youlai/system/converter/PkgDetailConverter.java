package com.youlai.system.converter;

import com.youlai.system.model.entity.PkgDetailEntity;
import com.youlai.system.model.entity.SysDept;
import com.youlai.system.model.form.PkgDetailForm;
import com.youlai.system.model.vo.DeptVO;
import com.youlai.system.model.vo.PkgDetailVO;
import org.mapstruct.Mapper;

/**
 * 部门对象转换器
 *
 * @author ross
 * @since 2022/7/29
 */
@Mapper(componentModel = "spring")
public interface PkgDetailConverter {

    // entity2Page
//    Page<PkgDetailVO> entity2Page(Page<PkgEntity> page);

    PkgDetailForm entity2Form(PkgDetailEntity entity);
    PkgDetailVO entity2VO(PkgDetailEntity entity);

    PkgDetailEntity  form2Entity(PkgDetailForm form);
}