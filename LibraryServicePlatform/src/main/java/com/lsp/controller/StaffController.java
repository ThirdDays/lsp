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
            request.setAttribute("msg",true);
            return "jsp/admin/addStaff.jsp";
        }
        request.setAttribute("msg",false);
        return "jsp/admin/addStaff.jsp";
    }
    @RequestMapping("/deleteStaff.do")
    public String deleteStaff(String staffId,HttpServletRequest request) {
//        StaffService staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        int result=staffService.deleteStaff(staffId);
        boolean bool = userService.deleteUser(staffId);
        if(result > 0 && bool == true) {
            request.setAttribute("msg",true);
            return "jsp/admin/deleteStaff.jsp";
        }
        request.setAttribute("msg",false);
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
            request.setAttribute("msg",true);
            return "jsp/admin/modifyStaff.jsp";
        }
        request.setAttribute("msg",false);
        return "jsp/admin/modifyStaff.jsp";
    }


    @RequestMapping("/queryStaffById.do")
    public String queryStaffById(String staffId) {
        Staff staff=staffService.findStaffById(staffId);
        return null;
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
            return "jsp/custom_service/custom_service_master.jsp";
        }
        return "index.jsp";                                 //登录失败返回首页
//        ModelAndView modelAndView=new ModelAndView();
//        if(bool) {
//            httpSession.setAttribute("staIdSession",staffId);
//            httpSession.setAttribute("passwordsSession",passwords);
//
//            Cookie staIdCookie=new Cookie("staIdCookie",staffId);
//            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
//            httpServletResponse.addCookie(staIdCookie);
//            httpServletResponse.addCookie(passwordsCookie);
//
//            modelAndView.addObject("msg","登录成功！");
//            modelAndView.setViewName("");       //以后在写
//            return modelAndView;
//        }
//        modelAndView.addObject("msg","工号或密码错误！");
//        modelAndView.setViewName("/jsp/custom_service/custom_service_master.jsp");           //以后在写
//        return modelAndView;
    }

    //本方法以后在具体补充，登出日志暂时不考虑
    @RequestMapping("/staffLogout.do")
    public String staffLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {       //登出，主要是清除cookies和记录登出日志（记录登出日志暂时不考虑）
        Cookie[] cookies=httpServletRequest.getCookies();
        for(Cookie cookie:cookies) {
            cookie.setMaxAge(0);            //消除cookie
            httpServletResponse.addCookie(cookie);
        }
        httpSession.removeAttribute("staIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return null;
    }

    @RequestMapping("/modifyStaffPasswords.do")
    public ModelAndView modifyStaffPasswords(String staId,String newPasswords) {       //修改密码
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

    //签到
    @RequestMapping("/staffSignIn.do")
    public String staffSignIn(String staffId) {
        String result = staffService.sign(staffId);            //执行签到
        return null;
    }

}
