package com.youlai.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.common.enums.StatusEnum;
import com.youlai.common.web.model.Option;
import com.youlai.system.converter.PkgConverter;
import com.youlai.system.mapper.SysPkgMapper;
import com.youlai.system.model.entity.PkgEntity;
import com.youlai.system.model.form.PkgForm;
import com.youlai.system.model.query.PkgPageQuery;
import com.youlai.system.model.vo.PkgPageVO;
import com.youlai.system.model.vo.RolePageVO;
import com.youlai.system.service.SysPkgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 部门表(SysPkg)表服务实现类
 *
 * @author wangjw
 * @since 2024-04-08 13:39:51
 */
@Service("sysPkgService")
@RequiredArgsConstructor
public class SysPkgServiceImpl extends ServiceImpl<SysPkgMapper, PkgEntity> implements SysPkgService {

    private final PkgConverter converter;

    /**
     * 角色分页列表
     *
     * @param queryParams 角色查询参数
     * @return {@link Page<RolePageVO>} – 角色分页列表
     */
    @Override
    public Page<PkgPageVO> getPage(PkgPageQuery queryParams) {

        // 查询参数
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        String keywords = queryParams.getKeywords();

        // 查询数据
        Page<PkgEntity> pkgPage = this.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<PkgEntity>()
                        .and(StrUtil.isNotBlank(keywords),
                                wrapper ->
                                        wrapper.like(StrUtil.isNotBlank(keywords), PkgEntity::getName, keywords)
                                                .or()
                                                .like(StrUtil.isNotBlank(keywords), PkgEntity::getLocation, keywords)
                        )

        );

        // 实体转换
        Page<PkgPageVO> pageResult = converter.entity2Page(pkgPage);
        return pageResult;
    }


    /**
     * 部门下拉选项
     *
     * @return 部门下拉List集合
     */
    @Override
    public List<Option> listPkgOptions() {

        List<PkgEntity> pkgList = this.list(new LambdaQueryWrapper<PkgEntity>()
                .eq(PkgEntity::getStatus, StatusEnum.ENABLE.getValue())
                .select(PkgEntity::getId, PkgEntity::getParentId, PkgEntity::getName)
                .orderByAsc(PkgEntity::getSort)
        );

        Set<Long> parentIds = pkgList.stream()
                .map(PkgEntity::getParentId)
                .collect(Collectors.toSet());

        Set<Long> deptIds = pkgList.stream()
                .map(PkgEntity::getId)
                .collect(Collectors.toSet());

        List<Long> rootIds = CollectionUtil.subtractToList(parentIds, deptIds);

        List<Option> list = new ArrayList<>();
        for (Long rootId : rootIds) {
            list.addAll(recurTreeOptions(rootId, pkgList));
        }
        return list;
    }

    /**
     * 递归生成部门表格层级列表
     *
     * @param parentId
     * @param pkgList
     * @return
     */
    public static List<Option> recurTreeOptions(long parentId, List<PkgEntity> pkgList) {
        List<Option> list = CollectionUtil.emptyIfNull(pkgList).stream()
                .filter(dept -> dept.getParentId().equals(parentId))
                .map(dept -> {
                    Option option = new Option(dept.getId(), dept.getName());
                    List<Option> children = recurTreeOptions(dept.getId(), pkgList);
                    if (CollectionUtil.isNotEmpty(children)) {
                        option.setChildren(children);
                    }
                    return option;
                })
                .collect(Collectors.toList());
        return list;
    }


    /**
     * 保存角色
     *
     * @param form 角色表单数据
     * @return {@link Boolean}
     */
    @Override
    public boolean savePkg(PkgForm form) {

        Long id = form.getId();

        PkgEntity entity = null;
        if (id != null) {
            entity = this.getById(id);
            Assert.isTrue(entity != null, "pkg不存在");
        }

        String code = form.getCode();
        long count = this.count(new LambdaQueryWrapper<PkgEntity>()
                .ne(id != null, PkgEntity::getId, id)
                .and(wrapper ->
                        wrapper.eq(PkgEntity::getCode, code).or().eq(PkgEntity::getName, form.getName())
                ));
        Assert.isTrue(count == 0, "编码已存在，请修改后重试！");

        // 实体转换
        entity = converter.form2Entity(form);
        boolean result = this.saveOrUpdate(entity);
//        if (result) {
//            // 判断角色编码或状态是否修改，修改了则刷新权限缓存
//            if (entity != null
//                    && (
//                    !StrUtil.equals(entity.getCode(), roleCode) ||
//                            !ObjectUtil.equals(entity.getStatus(), roleForm.getStatus())
//            )) {
//                roleMenuService.refreshRolePermsCache(entity.getCode(), roleCode);
//            }
//        }
        return result;
    }

    /**
     * 获取角色表单数据
     *
     * @param id 角色ID
     * @return {@link PkgForm} – 角色表单数据
     */
    @Override
    public PkgForm getPkgForm(Long id) {
        PkgEntity entity = this.getById(id);
        return converter.entity2Form(entity);
    }

    /**
     * 批量删除角色
     *
     * @param ids 角色ID，多个使用英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePkgs(String ids) {
        List<Long> lngIds = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();

        for (Long id : lngIds) {
            PkgEntity entity = this.getById(id);
            Assert.isTrue(entity != null, "id= " + id + " pkg不存在");

            boolean result = this.removeById(id);
        }
        return true;
    }

    /**
     * 修改pkg状态
     *
     * @param id     ID
     * @param status 状态(1:启用；0:禁用)
     * @return {@link Boolean}
     */
    @Override
    public boolean updatePkgStatus(Long id, Integer status) {
        PkgEntity entity = this.getById(id);
        Assert.isTrue(entity != null, "pkg不存在");

        entity.setStatus(status);
        boolean result = this.updateById(entity);
        return result;
    }

}

