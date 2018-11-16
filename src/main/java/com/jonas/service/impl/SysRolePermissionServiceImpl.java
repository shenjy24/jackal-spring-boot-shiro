package com.jonas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jonas.entity.SysRolePermission;
import com.jonas.mapper.SysRolePermissionMapper;
import com.jonas.service.SysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jonas
 * @since 2018-11-10
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Override
    public List<SysRolePermission> listSysRolePermission(Long roleId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id", roleId);

        return baseMapper.selectList(wrapper);
    }
}
