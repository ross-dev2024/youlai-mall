package com.youlai.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.system.mapper.SysPkgDetailMapper;
import com.youlai.system.model.bo.UserBO;
import com.youlai.system.model.entity.PkgDetailEntity;
import com.youlai.system.model.query.PkgDetailPageQuery;
import com.youlai.system.model.vo.PkgDetailPageVO;
import com.youlai.system.service.SysPkgDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息表(SysPkgDetail)表服务实现类
 *
 * @author wangjw
 * @since 2024-04-13 19:18:31
 */
@Service("sysPkgDetailService")
@RequiredArgsConstructor
public class SysPkgDetailServiceImpl extends ServiceImpl<SysPkgDetailMapper, PkgDetailEntity> implements SysPkgDetailService {

    @Override
    public Page<PkgDetailPageVO> selectPkgDetailPage(PkgDetailPageQuery queryParams) {

        // 参数构建
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        String keywords = queryParams.getKeywords();
        Page<PkgDetailPageVO> page = new Page<>(pageNum, pageSize);

//        QueryWrapper<PkgDetailEntity> wrapper = new QueryWrapper<>();
//        if( (keywords != null) && keywords.trim()!="") {
//            wrapper.like("",1);
//            wrapper.like("",2);
//            User::getName,
//            wrapper.and(i -> i.like("d.name",'%'+ keywords +'%')
//                    .nested(i -> i.or(k -> j.eq("name", "a").eq("age", 2))

//                w.and(i -> i.eq("1", 1))
//                .nested(i ->
//                        i.and(j -> j.eq("name", "a").eq("age", 2))
//                                .or(j -> j.eq("name", "b").eq("age", 2)));
//        }

//        //        u.deleted = 0 AND u.username != 'root'
//        <if test='keywords!=null and keywords.trim() neq ""'>
//            AND (u.username LIKE CONCAT('%',#{keywords},'%')
//            OR u.nickname LIKE CONCAT('%',#{keywords},'%')
//            OR u.mobile LIKE CONCAT('%',#{keywords},'%'))
//        </if>
//
//        <if test='status!=null'>
//            AND u.status = #{status}
//        </if>
//
//        <if test='deptId!=null'>
//            AND concat(',',concat(d.tree_path,',',d.id),',') like concat('%,',#{deptId},',%')
//        </if>

        return baseMapper.selectPkgDetailPage(page, queryParams);
    }
}

