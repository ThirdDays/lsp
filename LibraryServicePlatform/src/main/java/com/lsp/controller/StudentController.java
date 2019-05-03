package com.lsp.controller;

import com.lsp.domain.po.Student;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;
import com.lsp.service.interfaces.StudentService;
import com.lsp.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    /*
        function:学生信息注册
        @return:返回视图名
     */
    @RequestMapping("/addStu.do")
    public String addStu(Student stu,HttpServletRequest request){
        int result=studentService.insertStudent(stu);
        boolean bool = userService.addUser(stu.getStuId(),stu.getStuName());
        if(result>0&&bool==true) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/addStu.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/addStu.jsp";
    }
    /*
        function:删除学生信息
     */
    @RequestMapping("/deleteStu.do")
    public String deleteStu(String stuId,HttpServletRequest request) {
        int result=studentService.deleteStudent(stuId);
        boolean bool = userService.deleteUser(stuId);
        if(result>0&&bool == true) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/deleteStu.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/deleteStu.jsp";
    }
    /*
        function:修改学生信息
     */
    @RequestMapping("/modifyStu.do")
    public String modifyStu(Entity<Student> entity,HttpServletRequest request) {
        int result=studentService.updateStudent(entity);
        Entity<User> en = new Entity<User>();
        en.setId(entity.getId());
        User user = new User();
        user.setUserId(entity.getObject().getStuId());
        user.setUserName(entity.getObject().getStuName());
        en.setObject(user);
        boolean bool = userService.modifyUser(en);
        if(result>0&&bool==true) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/modifyStu.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/modifyStu.jsp";
    }
    /*
        function:查询学生信息
     */
    @RequestMapping("/queryStuById.do")
    public String queryStuById(String stuId,HttpServletRequest request) {
        Student stu = studentService.findStudentById(stuId);
        request.setAttribute("stu",stu);
        return "jsp/admin/queryStu.jsp";
    }
    @RequestMapping("/queryStuByName.do")
    public String queryStuByName(HttpServletRequest request) {
        return null;
    }


    /*
    function:学生登录
    @return:返回视图名
 */
    @RequestMapping("/stuLogin.do")
    public String stuLogin(HttpServletRequest request, HttpServletResponse httpServletResponse, HttpSession httpSession) {
        String stuId=request.getParameter("id");
        String passwords=request.getParameter("password");
        System.out.println(stuId+":"+passwords);
        boolean bool = studentService.login(stuId,passwords);
        if(bool) {
            httpSession.setAttribute("stuIdSession",stuId);
            httpSession.setAttribute("passwordsSession",passwords);

            Cookie stuIdCookie=new Cookie("stuIdCookie",stuId);
            Cookie passwordsCookie=new Cookie("passwordsCookie",passwords);
            httpServletResponse.addCookie(stuIdCookie);
            httpServletResponse.addCookie(passwordsCookie);
            request.setAttribute("id",stuId);
            return "jsp/ts/tsMaster.jsp";
        }
        request.setAttribute("msg","用户名或密码错误！");
        return "index.jsp";
    }
    /*
        function:修改密码
     */

    //登出
    @RequestMapping("/stuLogout.do")
    public String stuLogout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {
        Cookie[] cookies=httpServletRequest.getCookies();
        for(Cookie cookie:cookies) {
            cookie.setMaxAge(0);            //消除cookie
            httpServletResponse.addCookie(cookie);
        }
        httpSession.removeAttribute("stuIdSession");      //消除session域中的内容
        httpSession.removeAttribute("passwordsSession");
        return "index.jsp";
    }

    @RequestMapping("/modifyStuPasswords.do")
    public String modifyStuPasswords(String stuId,String newPasswords,HttpServletRequest request) {
        boolean bool = studentService.modifyPasswords(stuId,newPasswords);
        if(bool) {
            request.setAttribute("msg","修改密码成功！");
            return "jsp/ts/tsMaster.jsp";
        }
        request.setAttribute("msg","修改密码失败！");
        return "jsp/ts/modifyPasswords.jsp";
    }
}
