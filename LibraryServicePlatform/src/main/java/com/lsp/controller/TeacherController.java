package com.lsp.controller;

import com.lsp.domain.Teacher;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.TeacherService;
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
    /*
        function:教师信息注册
     */
    @RequestMapping("/teachRegister.do")
    public String teachRegister(Teacher teacher) {
        int result=teacherService.insertTeacher(teacher);
        if(result>0) {

        }
        return null;
    }
    /*
        function:教师信息删除
     */
    @RequestMapping("/teachDelete.do")
    public String teachDelete(String tId) {
        int result=teacherService.deleteTeacher(tId);
        //以下以后在补充
        if(result>0) {

        }
        return null;
    }
    /*
        function:教师信息修改
     */
    @RequestMapping("/teachUpdate.do")
    public String teachUpdate(Entity<Teacher> entity) {
        int result=teacherService.updateTeacher(entity);

        return null;
    }
    /*
        function:教师信息查询
     */
    @RequestMapping("/teachQueryById.do")
    public String teachQueryById(String tId) {
        Teacher teacher=teacherService.findTeacherById(tId);
        return null;
    }

    @RequestMapping("/teachQueryByName.do")
    public String teachQueryByName(String tName) {
        Teacher teacher=teacherService.findTeacherByName(tName);
        return null;
    }
    /*
        function:教师登录
     */
    @RequestMapping("/teachLogin.do")
    public ModelAndView teachLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String tId=request.getParameter("tId");
        String passwords=request.getParameter("passwords");
        boolean bool=teacherService.login(tId,passwords);
        ModelAndView modelAndView=new ModelAndView();
        if(bool) {
            session.setAttribute("tIdSession",tId);
            session.setAttribute("passwordsSession",passwords);
            Cookie tIdCookie=new Cookie("tIdCookie",tId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            response.addCookie(tIdCookie);
            response.addCookie(passwordsCookie);

            modelAndView.addObject("msg","登录成功！");
            modelAndView.setViewName("");       //以后在写
            return modelAndView;
        }
        modelAndView.addObject("msg","工号或密码错误！");
        modelAndView.setViewName("");       //以后在写
        return modelAndView;
    }

    @RequestMapping("/teachModifyPass.do")
    public ModelAndView modifyPasswords(String tId,String newPasswords) {     //修改密码
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
}
