package com.lsp.controller;

import com.lsp.domain.Staff;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff")
public class StaffController {

//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private StaffService staffService;
    @RequestMapping("/staffAdd.do")
    public String staffAdd(Staff staff) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.insertStaff(staff);
        if(result>0) {

        }
        return null;
    }
    @RequestMapping("/staffDelete.do")
    public String staffDelete(String staId) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.deleteStaff(staId);
        if(result > 0) {

        }
        return null;
    }
    @RequestMapping("/staffUpdate.do")
    public String staffUpdate(Entity<Staff> entity) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.updateStaff(entity);
        if(result>0) {

        }
        return null;
    }


    @RequestMapping("/staffQueryById.do")
    public String staffQueryById(String staId) {
        Staff staff=staffService.findStaffById(staId);

        return null;
    }
    @RequestMapping("/staffQueryByName.do")
    public String staffQueryByName(String staName) {
        Staff staff=staffService.findStaffByName(staName);
        return null;
    }
    @RequestMapping("/staffLogin.do")
    public ModelAndView staffLogin(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) {   //职工登录
        String staId=httpServletRequest.getParameter("staId");
        String passwords=httpServletRequest.getParameter("passwords");
        boolean bool=staffService.login(staId,passwords);
        ModelAndView modelAndView=new ModelAndView();
        if(bool) {
            httpSession.setAttribute("staIdSession",staId);
            httpSession.setAttribute("passwordsSession",passwords);

            Cookie staIdCookie=new Cookie("staIdCookie",staId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            httpServletResponse.addCookie(staIdCookie);
            httpServletResponse.addCookie(passwordsCookie);

            modelAndView.addObject("msg","登录成功！");
            modelAndView.setViewName("");       //以后在写
            return modelAndView;
        }
        modelAndView.addObject("msg","工号或密码错误！");
        modelAndView.setViewName("");           //以后在写
        return modelAndView;
    }
    @RequestMapping("/staffModifyPass.do")
    public ModelAndView staffModifyPass(String staId,String newPasswords) {       //修改密码
        boolean result=staffService.modifyPasswords(staId,newPasswords);
        ModelAndView modelAndView=new ModelAndView();
        if(result==true) {  //修改成功
            modelAndView.addObject("msg","修改密码成功！");
            modelAndView.setViewName("");
            return modelAndView;
        }
        modelAndView.addObject("msg","修改密码失败！");
        modelAndView.setViewName("");
        return modelAndView;
    }
    //本方法以后在具体补充，登出日志暂时不考虑
    public String adminLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {       //登出，主要是清除cookies和记录登出日志（记录登出日志暂时不考虑）
        Cookie[] cookies=httpServletRequest.getCookies();
        for(Cookie cookie:cookies) {
            cookie.setMaxAge(0);            //消除cookie
            httpServletResponse.addCookie(cookie);
        }
        httpSession.removeAttribute("staIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return null;
    }
    //签到
    @RequestMapping("/staffSignIn.do")
    public String staffSignIn(HttpServletRequest request) {
        return null;
    }

}
