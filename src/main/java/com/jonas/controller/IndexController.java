package com.jonas.controller;

import com.jonas.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/11/10
 */
@RestController
public class IndexController {
    /**
     * 首页，并将登录用户的全名返回前台
     * @return
     */
    @RequestMapping(value = {"/", "/index"})
    public SysUser index() {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return sysUser;
    }
}
