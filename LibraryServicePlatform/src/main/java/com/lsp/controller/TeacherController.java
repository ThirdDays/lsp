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
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/addTeach.jsp";
        }
        request.setAttribute("msg","操作失败！");
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
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/deleteTeach.jsp";
        }
        request.setAttribute("msg","操作失败！");
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
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/modifyTeach.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/modifyTeach.jsp";
    }
    /*
        function:教师信息查询
     */
    @RequestMapping("/queryTeachById.do")
    public String queryTeachById(String tId,HttpServletRequest request) {
        Teacher teacher=teacherService.findTeacherById(tId);
        request.setAttribute("teach",teacher);
        return "jsp/admin/queryTeach.jsp";
    }

    @RequestMapping("/queryTeachByName.do")
    public String teachQueryByName(String tName) {
        Teacher teacher=teacherService.findTeacherByName(tName);
//        request.setAttribute("teach",teacher);
//        return "jsp/admin/queryTeach.jsp";
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
            session.setAttribute("teachIdSession",teachId);
            session.setAttribute("passwordsSession",passwords);

            Cookie teachIdCookie=new Cookie("teachIdCookie",teachId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            response.addCookie(teachIdCookie);
            response.addCookie(passwordsCookie);
            request.setAttribute("id",teachId);
            return "jsp/ts/tsMaster.jsp";
        }
        request.setAttribute("msg","用户名或密码错误！");
        return "index.jsp";
    }

    //登出
    @RequestMapping("/teachLogout.do")
    public String teachLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {
        Cookie[] cookies=httpServletRequest.getCookies();
        for(Cookie cookie:cookies) {
            cookie.setMaxAge(0);            //消除cookie
            httpServletResponse.addCookie(cookie);
        }
        httpSession.removeAttribute("teachIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return "index.jsp";
    }

    @RequestMapping("/modifyTeachPasswords.do")
    public ModelAndView modifyTeachPasswords(String teachId,String newPasswords) {     //修改密码
        boolean bool=teacherService.modifyPasswords(teachId,newPasswords);
        ModelAndView modelAndView=new ModelAndView();
        if(bool) {
            modelAndView.addObject("msg","修改密码成功！");
            modelAndView.setViewName("jsp/ts/tsMaster.jsp");
            return modelAndView;
        }
        modelAndView.addObject("msg","修改密码失败！");
        modelAndView.setViewName("jsp/ts/modifyPasswords.jsp");
        return modelAndView;
    }
}
