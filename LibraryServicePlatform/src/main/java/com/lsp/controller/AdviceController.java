package com.lsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/advice")
public class AdviceController {

    /*
        function:图书馆公告通知
     */
    @RequestMapping("/libAdvice.do")
    public String libAdvice(HttpServletRequest request) {
        return null;
    }

    /*
        function:部门通知
     */
    @RequestMapping("/sectionAdvice.do")
    public String sectionAdvice(HttpServletRequest request) {
        return null;
    }
    /*
        function:个人通知
     */
    @RequestMapping("/personAdvice.do")
    public String personAdvice(HttpServletRequest request) {
        return null;
    }
}
