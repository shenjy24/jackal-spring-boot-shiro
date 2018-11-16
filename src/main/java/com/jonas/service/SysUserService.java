package com.jonas.service;

import com.jonas.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jonas
 * @since 2018-11-09
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getSysUser(String userName);
}
