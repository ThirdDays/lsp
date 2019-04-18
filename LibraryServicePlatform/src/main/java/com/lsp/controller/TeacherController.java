package com.lsp.controller;

import com.lsp.domain.po.Teacher;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;
import com.lsp.service.interfaces.TeacherService;
import com.lsp.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teach")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;
    /*
        function:教师信息注册
     */
    @RequestMapping("/addTeach.do")
    public String addTeach(Teacher teacher,HttpServletRequest request) {
        int result=teacherService.insertTeacher(teacher);
        boolean bool = userService.addUser(teacher.getTeachId(),teacher.getTeachName());
        if(result>0&&bool==true) {
            request.setAttribute("msg",true);
            return "jsp/admin/addTeach.jsp";
        }
        request.setAttribute("msg",false);
        return "jsp/admin/addTeach.jsp";
    }
    /*
        function:教师信息删除
     */
    @RequestMapping("/deleteTeach.do")
    public String deleteTeach(String teachId,HttpServletRequest request) {
        int result=teacherService.deleteTeacher(teachId);
        boolean bool=userService.deleteUser(teachId);
        //以下以后在补充
        if(result>0 && bool == true) {
            request.setAttribute("msg",true);
            return "jsp/admin/deleteTeach.jsp";
        }
        request.setAttribute("msg",false);
        return "jsp/admin/deleteTeach.jsp";
    }
    /*
        function:教师信息修改
     */
    @RequestMapping("/modifyTeach.do")
    public String modifyTeach(Entity<Teacher> entity,HttpServletRequest request) {
        int result=teacherService.updateTeacher(entity);
        Entity<User> en = new Entity<User>();
        en.setId(entity.getId());
        User user = new User();
        user.setUserId(entity.getObject().getTeachId());
        user.setUserName(entity.getObject().getTeachName());
        en.setObject(user);
        boolean bool = userService.modifyUser(en);
        if(result>0&&bool==true) {
            request.setAttribute("msg",true);
            return "jsp/admin/modifyTeach.jsp";
        }
        request.setAttribute("msg",false);
        return "jsp/admin/modifyTeach.jsp";
    }
    /*
        function:教师信息查询
     */
    @RequestMapping("/queryTeachById.do")
    public String queryTeachById(String tId) {
        Teacher teacher=teacherService.findTeacherById(tId);
        return null;
    }

    @RequestMapping("/queryTeachByName.do")
    public String teachQueryByName(String tName) {
        Teacher teacher=teacherService.findTeacherByName(tName);
        return null;
    }
    /*
        function:教师登录
     */
    @RequestMapping("/teachLogin.do")
    public String teachLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String teachId=request.getParameter("id");
        String passwords=request.getParameter("password");
        System.out.println(teachId+":"+passwords);

        boolean bool=teacherService.login(teachId,passwords);
        if(bool) {
            return "jsp/ts/tsMaster.jsp";
        }
//        ModelAndView modelAndView=new ModelAndView();
//        if(bool) {
//            session.setAttribute("tIdSession",teachId);
//            session.setAttribute("passwordsSession",passwords);
//            Cookie tIdCookie=new Cookie("tIdCookie",teachId);
//            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
//            response.addCookie(tIdCookie);
//            response.addCookie(passwordsCookie);
//
//            modelAndView.addObject("msg","登录成功！");
//            modelAndView.setViewName("");       //以后在写
//            return modelAndView;
//        }
//        modelAndView.addObject("msg","工号或密码错误！");
//        modelAndView.setViewName("");       //以后在写
//        return modelAndView;
        return "index.jsp";
    }

    //登出
    @RequestMapping("/teachLogout.do")
    public String teachLogout() {
        return null;
    }

    @RequestMapping("/modifyTeachPasswords.do")
    public ModelAndView modifyTeachPasswords(String tId,String newPasswords) {     //修改密码
        boolean bool=teacherService.modifyPasswords(tId,newPasswords);
        ModelAndView modelAndView=new ModelAndView();
        if(bool) {
            modelAndView.addObject("msg","修改密码成功！");
            modelAndView.setViewName("");
            return modelAndView;
        }
        modelAndView.addObject("msg","修改密码失败！");
        modelAndView.setViewName("");
        return modelAndView;
    }
    //本方法以后在具体补充，登出日志暂时不考虑
//    public String adminLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {       //登出，主要是清除cookies和记录登出日志（记录登出日志暂时不考虑）
//        Cookie[] cookies=httpServletRequest.getCookies();
//        for(Cookie cookie:cookies) {
//            cookie.setMaxAge(0);            //消除cookie
//            httpServletResponse.addCookie(cookie);
//        }
//        httpSession.removeAttribute("staIdSession");      //消除session域中的内容
//        httpSession.removeAttribute("passwordsSession");
//        return null;
//    }
}
