package com.lsp.controller;

import com.lsp.domain.po.Staff;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;
import com.lsp.service.interfaces.StaffService;
import com.lsp.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
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
    @Autowired
    private UserService userService;
    @RequestMapping("/addStaff.do")
    public String addStaff(Staff staff,HttpServletRequest request) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.insertStaff(staff);
        boolean bool = userService.addUser(staff.getStaffId(),staff.getStaffName());
        if(result>0 && bool == true) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/addStaff.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/addStaff.jsp";
    }
    @RequestMapping("/deleteStaff.do")
    public String deleteStaff(String staffId,HttpServletRequest request) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.deleteStaff(staffId);
        boolean bool = userService.deleteUser(staffId);
        if(result > 0 && bool == true) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/deleteStaff.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/deleteStaff.jsp";
    }
    @RequestMapping("/modifyStaff.do")
    public String modifyStaff(Entity<Staff> entity,HttpServletRequest request) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.updateStaff(entity);
        Entity<User> en = new Entity<User>();
        en.setId(entity.getId());
        User user = new User();
        user.setUserId(entity.getObject().getStaffId());
        user.setUserName(entity.getObject().getStaffName());
        en.setObject(user);
        boolean bool = userService.modifyUser(en);
        if(result>0 && bool == true) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/modifyStaff.jsp";
        }
        request.setAttribute("msg","操作成功");
        return "jsp/admin/modifyStaff.jsp";
    }


    @RequestMapping("/queryStaffById.do")
    public String queryStaffById(String staffId,HttpServletRequest request) {
        Staff staff=staffService.findStaffById(staffId);
        request.setAttribute("staff",staff);
        return "jsp/admin/queryStaff.jsp";
    }
    @RequestMapping("/queryStaffByName.do")
    public String queryStaffByName(String staffName) {
        Staff staff=staffService.findStaffByName(staffName);
        return null;
    }

    @RequestMapping("/staffLogin.do")
    public String staffLogin(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) {   //职工登录
        String staffId=httpServletRequest.getParameter("id");
        String passwords=httpServletRequest.getParameter("password");
        boolean bool=staffService.login(staffId,passwords);
        if(bool) {
            httpSession.setAttribute("staffIdSession",staffId);
            httpSession.setAttribute("passwordsSession",passwords);

            Cookie staffIdCookie=new Cookie("staffIdCookie",staffId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            httpServletResponse.addCookie(staffIdCookie);
            httpServletResponse.addCookie(passwordsCookie);
            httpServletRequest.setAttribute("id",staffId);
            return "jsp/custom_service/custom_service_master.jsp";
        }
        httpServletRequest.setAttribute("msg","用户名或密码错误！");
        return "index.jsp";                                 //登录失败返回首页
    }

    //本方法以后在具体补充，登出日志暂时不考虑
    @RequestMapping("/staffLogout.do")
    public String staffLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {       //登出，主要是清除cookies和记录登出日志（记录登出日志暂时不考虑）
        Cookie[] cookies=httpServletRequest.getCookies();
        for(Cookie cookie:cookies) {
            cookie.setMaxAge(0);            //消除cookie
            httpServletResponse.addCookie(cookie);
        }
        httpSession.removeAttribute("staffIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return "index.jsp";
    }

    @RequestMapping("/modifyStaffPasswords.do")
    public String modifyStaffPasswords(String staffId,String newPasswords,HttpServletRequest request) {       //修改密码
        boolean result=staffService.modifyPasswords(staffId,newPasswords);
        if(result==true) {  //修改成功
            request.setAttribute("msg","修改密码成功！");
            return "jsp/custom_service/custom_service_master.jsp";
        }
        request.setAttribute("msg","修改密码失败！");
        return "jsp/custom_service/modifyPasswords.jsp";
    }

    //签到
    @RequestMapping("/staffSignIn.do")
    public String staffSignIn(String staffId,HttpServletRequest request) {
        String result = staffService.sign(staffId);            //执行签到
        if(result == null) {
            request.setAttribute("msg","签到失败！");
            return "jsp/custom_service/custom_service_master.jsp";
        }
        request.setAttribute("msg","签到成功！");
        return "jsp/custom_service/custom_service_master.jsp";
    }

}
