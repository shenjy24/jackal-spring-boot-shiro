package com.jonas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonas.entity.SysPermission;
import com.jonas.entity.SysRolePermission;
import com.jonas.entity.SysUserRole;
import com.jonas.mapper.SysPermissionMapper;
import com.jonas.service.SysPermissionService;
import com.jonas.service.SysRolePermissionService;
import com.jonas.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jonas
 * @since 2018-11-10
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Override
    public List<SysPermission> listSysPermission(List<Long> permissionIds) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("id", permissionIds);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<String> selectPermissionByUserId(Long userId) {
        SysUserRole sysUserRole = sysUserRoleService.getById(userId);
        if (null == sysUserRole) {
            return Collections.EMPTY_LIST;
        }

        List<SysRolePermission> sysRolePermissions = sysRolePermissionService.listSysRolePermission(sysUserRole.getRoleId());
        if (CollectionUtils.isEmpty(sysRolePermissions)) {
            return Collections.EMPTY_LIST;
        }

        List<Long> permissionIds = sysRolePermissions.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        Collection<SysPermission> sysPermissions = this.listSysPermission(permissionIds);
        if (CollectionUtils.isEmpty(sysPermissions)) {
            return Collections.EMPTY_LIST;
        }

        List<String> permissions = sysPermissions.stream().map(SysPermission::getPermission).distinct().collect(Collectors.toList());;
        return permissions;
    }
}
