package com.lsp.controller;

import com.lsp.domain.po.Admin;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;
import com.lsp.service.interfaces.AdminService;
import com.lsp.service.interfaces.UserService;
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
public class AdminContorller {

//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;
    /*
        function:管理员信息注册
     */
    @RequestMapping("/addAdmin.do")
    public String addAdmin(Admin admin,HttpServletRequest request) {        //参数为管理员注册信息的封装类
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        int result=adminService.insertAdmin(admin);        //执行添加（注册）操作
        boolean bool = userService.addUser(admin.getAdminId(),admin.getAdminName());
//        ModelAndView modelAndView=new ModelAndView();
        if(result>0 && bool == true) {  //注册成功
            request.setAttribute("msg","操作成功！");
            System.out.println("successful");
            return "jsp/admin/addAdmin.jsp";
        }
        System.out.println("fail");
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/addAdmin.jsp";    //注册失败
    }
    /*
        function:管理员信息删除，也就是注销
     */
    @RequestMapping("/deleteAdmin.do")
    public String deleteAdmin(String adminId,HttpServletRequest request) {         //参数为管理员Id编号或账号
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        int result=adminService.deleteAdminById(adminId);       //执行删除操作
        boolean bool=userService.deleteUser(adminId);
//        ModelAndView modelAndView=new ModelAndView();
        if(result>0 && bool==true) {  //删除成功
            request.setAttribute("msg","操作成功！");
            System.out.println("successful");
            return "jsp/admin/deleteAdmin.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/deleteAdmin.jsp";    //删除失败
    }
    /*
        function:管理员信息更新
     */
    @RequestMapping("/modifyAdmin.do")
    public String modifyAdmin(Entity<Admin> entity,HttpServletRequest request) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        int result=adminService.updateAdmin(entity);           //执行更新管理员信息的操作
        Entity<User> en = new Entity<User>();
        en.setId(entity.getId());
        User user = new User();
        user.setUserId(entity.getObject().getAdminId());
        user.setUserName(entity.getObject().getAdminName());
        en.setObject(user);
        boolean bool = userService.modifyUser(en);
        if(result>0 && bool == true) {  //更新成功
            request.setAttribute("msg","操作成功！");
            System.out.println("successful");
            return "jsp/admin/modifyAdmin.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/modifyAdmin.jsp";   //更新失败
    }

    /*
        function:管理员信息查询
     */
    @RequestMapping("/queryAdminById.do")
    public String queryAdminById(String adminId,HttpServletRequest request) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        Admin admin=adminService.findAdminById(adminId);
        request.setAttribute("admin",admin);
        return "jsp/admin/queryAdmin.jsp";
    }
    @RequestMapping("/queryAdminByName.do")
    public String queryAdminByName(String adminName) {
//        AdminService adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
        Admin admin=adminService.findAdminByName(adminName);
        return null;
    }



    /*
        function:管理员登录
     */
    @RequestMapping("/adminLogin.do")
    public String adminLogin(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) {
        String adminId=httpServletRequest.getParameter("id");
        String passwords=httpServletRequest.getParameter("password");
        System.out.println(adminId+":"+passwords);

        boolean result=adminService.login(adminId,passwords);       //执行登录操作
        if(result) {        //登录成功
            httpSession.setAttribute("adminIdSession",adminId);
            httpSession.setAttribute("passwordsSession",passwords);

            Cookie adminIdCookie=new Cookie("adminIdCookie",adminId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            httpServletResponse.addCookie(adminIdCookie);
            httpServletResponse.addCookie(passwordsCookie);

            httpServletRequest.setAttribute("id",adminId);
            return "jsp/admin/adminMaster.jsp";
        }
        httpServletRequest.setAttribute("msg","用户名或密码错误！");
        return "index.jsp";                                 //登录失败返回首页
    }

    @RequestMapping("/adminLogout.do")
    public String adminLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {       //登出，主要是清除cookies和记录登出日志（记录登出日志暂时不考虑）
        Cookie[] cookies=httpServletRequest.getCookies();
        for(Cookie cookie:cookies) {
            cookie.setMaxAge(0);            //消除cookie
            httpServletResponse.addCookie(cookie);
        }
        httpSession.removeAttribute("adminIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return "index.jsp";
    }
    /*
        function:修改密码
     */
    @RequestMapping("/modifyAdminPasswords.do")
    public String modifyAdminPasswords(String adminId,String oldPasswords,String newPasswords,HttpServletRequest request) {
        boolean result = adminService.modifyPasswords(adminId, newPasswords);  //修改密码操作

        if (result == true) {  //修改成功
            request.setAttribute("msg","修改密码成功！");
            return "jsp/admin/adminMaster.jsp";
        }
        request.setAttribute("msg","修改密码失败！");
        return "jsp/admin/modifyPasswords.jsp";
    }

    //管理员签到
    @RequestMapping("/adminSignIn.do")
    public String adminSignIn() {
//        adminService.
        return null;
    }
}
