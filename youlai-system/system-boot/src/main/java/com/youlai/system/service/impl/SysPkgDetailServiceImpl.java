package com.youlai.system.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.system.converter.PkgDetailConverter;
import com.youlai.system.mapper.SysPkgDetailMapper;
import com.youlai.system.model.entity.PkgDetailEntity;
import com.youlai.system.model.form.PkgDetailForm;
import com.youlai.system.model.query.PkgDetailPageQuery;
import com.youlai.system.model.vo.PkgDetailPageVO;
import com.youlai.system.service.SysPkgDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    private final PkgDetailConverter converter;

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


    /**
     * 保存角色
     *
     * @param form 角色表单数据
     * @return {@link Boolean}
     */
    @Override
    public boolean createOrUpdate(Long id, PkgDetailForm form) {

        PkgDetailEntity entity = null;
        if (id != null) {
            entity = this.getById(id);
            Assert.isTrue(entity != null, "pkg不存在");

        }

        // 实体转换
        entity = converter.form2Entity(form);
        if (id != null) {
            entity.setId(id);
        }

        boolean result = this.saveOrUpdate(entity);
        return result;
    }

    /**
     * 获取表单数据
     *
     * @param id ID
     * @return {@link PkgDetailForm} – 表单数据
     */
    @Override
    public PkgDetailForm getItem(Long id) {
        PkgDetailEntity entity = this.getById(id);
        return converter.entity2Form(entity);
    }

    /**
     * 批量删除角色
     *
     * @param ids 角色ID，多个使用英文逗号(,)分割
     * @return
     */
    @Override
    public boolean delete(String ids) {
        List<Long> lngIds = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        for (Long id : lngIds) {
            PkgDetailEntity entity = this.getById(id);
            Assert.isTrue(entity != null, "id= " + id + " pkg不存在");
            boolean result = this.removeById(id);
        }
        return true;
    }
}

