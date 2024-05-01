package com.youlai.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.common.web.model.Option;
import com.youlai.system.model.entity.PkgEntity;
import com.youlai.system.model.form.PkgForm;
import com.youlai.system.model.query.PkgPageQuery;
import com.youlai.system.model.vo.PkgPageVO;

import java.util.List;

/**
 * 部门表(SysPkg)表服务接口
 *
 * @author ross.dev
 * @since 2024-04-08 13:39:51
 */
public interface SysPkgService extends IService<PkgEntity> {

    /**
     * 分页列表
     *
     * @param queryParams 角色查询参数
     * @return {@link Page < PkgPageVO >} – 角色分页列表
     */
    Page<PkgPageVO> getPage(PkgPageQuery queryParams);

    /**
     * pkg树形下拉选项
     *
     * @return
     */
    List<Option> listPkgOptions();

    /**
     * 保存
     *
     * @param pkgForm pkg表单数据
     * @return {@link Boolean}
     */
    boolean savePkg(PkgForm pkgForm);

    /**
     * 获取pkg单数据
     *
     * @param id 角色ID
     * @return  {@link PkgForm} – pkg单数据
     */
    PkgForm getPkgForm(Long id);

    /**
     * 批量删除pkg
     *
     * @param ids 角色ID，多个使用英文逗号(,)分割
     * @return {@link Boolean}
     */
    boolean deletePkgs(String ids);

   /**
     * 修改状态
     *
     * @param roleId ID
     * @param status 状态(1:启用；0:禁用)
     * @return {@link Boolean}
     */
    boolean updatePkgStatus(Long roleId, Integer status);

}

