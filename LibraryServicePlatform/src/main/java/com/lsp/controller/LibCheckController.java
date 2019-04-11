package com.lsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/system")
public class LibCheckController {

    /*
        function: 入馆认证
     */
    @RequestMapping("/userCheck.do")
    public String userCheck(String id) {

        return null;
    }
}
