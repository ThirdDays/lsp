package com.lsp.controller;

import com.lsp.domain.Admin;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminContorller extends ApplicationObjectSupport {

//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private AdminService adminService;
    /*
        function:管理员信息注册
     */
    @RequestMapping("/adminRegister")
    public ModelAndView adminRegister(Admin admin) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        int result=adminService.insertAdmin(admin);
//        ModelAndView modelAndView=new ModelAndView();
        if(result>0) {  //注册成功

        }
        return null;    //注册失败
    }
    /*
        function:管理员信息删除，也就是注销
     */
    @RequestMapping("/adminDelete")
    public String adminDelete(String adminId) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        int result=adminService.deleteAdminById(adminId);
//        ModelAndView modelAndView=new ModelAndView();
        if(result>0) {  //删除成功

        }
        return null;    //删除失败
    }
    /*
        function:管理员信息更新
     */
    @RequestMapping("/adminUpdate")
    public String adminUpdate(Entity<Admin> entity) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        int result=adminService.updateAdmin(entity);
        if(result>0) {  //更新成功

        }
        return null;    //更新失败
    }

    /*
        function:管理员信息查询
     */
    @RequestMapping("/adminQuery")
    public String adminQueryById(String adminId) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        Admin admin=adminService.findAdminById(adminId);
        return null;
    }
    @RequestMapping("/findAdminByName")
    public String findAdminByName(String adminName) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        Admin admin=adminService.findAdminByName(adminName);
        return null;
    }

    /*
        function:管理员登录
     */
    @RequestMapping("/adminLogin")
    public ModelAndView adminLogin(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) {
        String adminId=httpServletRequest.getParameter("adminId");
        String passwords=httpServletRequest.getParameter("passwords");

        boolean result=adminService.login(adminId,passwords);
        ModelAndView modelAndView=new ModelAndView();
        if(result==true) {  //登录成功
            httpSession.setAttribute("adminIdSession",adminId);
            httpSession.setAttribute("passwordsSession",passwords);

            Cookie adminIdCookie=new Cookie("adminIdCookie",adminId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            httpServletResponse.addCookie(adminIdCookie);
            httpServletResponse.addCookie(passwordsCookie);

            modelAndView.addObject("msg","登录成功！");
            modelAndView.setViewName("");
            return modelAndView;
        }
        modelAndView.addObject("msg","工号或密码错误！");
        modelAndView.setViewName("");
        return modelAndView;

    }
    /*
        function:修改密码
     */
    @RequestMapping("/adminModifyPasswords")
    public ModelAndView adminModifyPasswords(String adminId,String newPasswords) {
        boolean result=adminService.modifyPasswords(adminId,newPasswords);  //修改密码操作
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
        httpSession.removeAttribute("adminIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return null;
    }
}
