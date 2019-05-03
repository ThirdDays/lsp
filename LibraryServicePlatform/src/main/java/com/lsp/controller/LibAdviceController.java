package com.lsp.controller;

import com.lsp.domain.po.LibAdvice;
import com.lsp.service.interfaces.LibAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/libAdvice")
public class LibAdviceController {

    @Autowired
    private LibAdviceService libAdviceService;
    @RequestMapping("/addLibAdvice.do")
    public String addLibAdvice(String content,HttpServletRequest request) {
        boolean bool = libAdviceService.addLibAdvice(content);
        if(bool) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/addLibAdvice.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/addLibAdvice.jsp";
    }

//    @RequestMapping("/deleteLibAdvice.do")
//    public String deleteLibAdvice(String id) {      //删除图书馆公告,该方法现在不考虑
//        return null;
//    }

//    @RequestMapping("/modifyLibAdvice.do")
//    public String modifyLibAdvice(String id) {      //修改图书馆公告，但正常情况下可以通过添加新的公告来覆盖掉原来的公告以实现修改的目的
//        return null;
//    }

    @RequestMapping("/queryLibAdvice.do")
    public ModelAndView queryLibAdvice() {
        System.out.println("queryLibAdvice");
        List<LibAdvice> list = libAdviceService.queryLibAdvice();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/common/queryLibAdvice.jsp");
        modelAndView.addObject("libAdviceList",list);
        for(LibAdvice libAdvice:list) {
            System.out.println(libAdvice);
        }
        return modelAndView;
    }
}
