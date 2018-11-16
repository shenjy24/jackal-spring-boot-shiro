package com.jonas.service;

import com.jonas.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jonas
 * @since 2018-11-10
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {

    List<SysRolePermission> listSysRolePermission(Long roleId);
}
