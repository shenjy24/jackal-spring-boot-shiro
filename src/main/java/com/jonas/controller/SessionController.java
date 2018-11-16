package com.jonas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/11/11
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/setSession")
    public String setSession(HttpSession httpSession, String value) {
        httpSession.setAttribute("val", value);
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpSession httpSession) {
        return (String) httpSession.getAttribute("val");
    }
}
