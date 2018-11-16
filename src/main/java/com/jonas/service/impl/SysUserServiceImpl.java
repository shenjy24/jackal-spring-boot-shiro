package com.jonas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jonas.entity.SysUser;
import com.jonas.mapper.SysUserMapper;
import com.jonas.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jonas
 * @since 2018-11-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser getSysUser(String userName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name", userName);

        return baseMapper.selectOne(wrapper);
    }
}
