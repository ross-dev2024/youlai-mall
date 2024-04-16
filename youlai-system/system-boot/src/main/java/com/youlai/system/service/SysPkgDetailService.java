package com.youlai.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.system.model.entity.PkgDetailEntity;
import com.youlai.system.model.query.PkgDetailPageQuery;
import com.youlai.system.model.vo.PkgDetailPageVO;

/**
 * 用户信息表(SysPkgDetail)表服务接口
 *
 * @author wangjw
 * @since 2024-04-13 19:18:31
 */
public interface SysPkgDetailService extends IService<PkgDetailEntity> {

    Page<PkgDetailPageVO> selectPkgDetailPage(PkgDetailPageQuery queryParams);

}


