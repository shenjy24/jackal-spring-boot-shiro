package com.jonas;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ApplicationTest {

    @Test
    public void testShiro() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111");
        subject.login(token);

        boolean isAuth = subject.isAuthenticated();
        System.out.println("是否认证通过 " + isAuth);

        // 退出操作
        subject.logout();
        // 是否认证通过
        isAuth = subject.isAuthenticated();
        System.out.println("是否认证通过：" + isAuth);
    }
}
