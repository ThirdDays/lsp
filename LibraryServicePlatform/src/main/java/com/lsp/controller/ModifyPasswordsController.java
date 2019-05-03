package com.lsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModifyPasswordsController {

    @RequestMapping("/modifyPasswords.do")
    public String modifyPasswords(String identifier,String userId,String oldPasswords,String newPasswords) {
        if(identifier.equals("admin")) {

        }
        return null;
    }
}
