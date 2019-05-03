package com.lsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @RequestMapping("/login")
    public String login(String id,String password,String identifier) {
        System.out.println("login");
        if(identifier.equals("admin")) {
            return "admin/adminLogin.do";
        }else if(identifier.equals("customService")) {
            return "staff/staffLogin.do";
        }else if(identifier.equals("teachr")) {
            return "teach/teachLogin.do";
        }else if(identifier.equals("stu")) {
            return "stu/stuLogin.do";
        } else {
            return "stu/stuLogin.do";
        }
    }
}
