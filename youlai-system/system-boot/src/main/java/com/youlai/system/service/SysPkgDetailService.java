package com.youlai.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.system.model.entity.PkgDetailEntity;
import com.youlai.system.model.form.PkgDetailForm;
import com.youlai.system.model.query.PkgDetailPageQuery;
import com.youlai.system.model.vo.PkgDetailPageVO;
import com.youlai.system.model.vo.PkgDetailVO;

/**
 * 用户信息表(SysPkgDetail)表服务接口
 *
 * @author wangjw
 * @since 2024-04-13 19:18:31
 */
public interface SysPkgDetailService extends IService<PkgDetailEntity> {

    Page<PkgDetailPageVO> selectPkgDetailPage(PkgDetailPageQuery queryParams);

    /**
     * 保存
     *
     * @param pkgForm pkg表单数据
     * @return {@link Boolean}
     */
    boolean createOrUpdate(Long id, PkgDetailForm pkgForm);

    /**
     * 获取pkg单数据
     *
     * @param id 角色ID
     * @return  {@link PkgDetailForm} – pkg单数据
     */
    PkgDetailVO getItem(Long id);

    /**
     * 批量删除item
     *
     * @param ids 角色ID，多个使用英文逗号(,)分割
     * @return {@link Boolean}
     */
    boolean delete(String ids);

}


