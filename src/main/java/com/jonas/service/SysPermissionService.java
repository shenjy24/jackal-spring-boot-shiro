package com.jonas.service;

import com.jonas.entity.SysPermission;
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
public interface SysPermissionService extends IService<SysPermission> {

    List<String> selectPermissionByUserId(Long userId);

    List<SysPermission> listSysPermission(List<Long> permissionIds);
}
