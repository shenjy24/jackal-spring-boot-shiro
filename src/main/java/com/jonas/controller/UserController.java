package com.jonas.controller;


import com.jonas.entity.SysUser;
import com.jonas.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jonas
 * @since 2018-11-09
 */
@RestController
//@RequestMapping("/sysUser")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getSysUser")
    public SysUser getSysUser(Long userId) {
        return sysUserService.getById(userId);
    }

    @RequestMapping("/login")
    public String login(String userName, String pwd) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
        try {
            user.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "账号不存在";
        } catch (DisabledAccountException e) {
            e.printStackTrace();
            return "账号未启用";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "密码错误";
        } catch (Throwable e) {
            e.printStackTrace();
            return "未知错误";
        }
        return "success";
    }

    @RequestMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "logout";
    }
}

