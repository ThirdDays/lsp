package com.lsp.controller;

import com.lsp.domain.Student;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /*
        function:学生信息注册
        @return:返回视图名
     */
    @RequestMapping("/stuRegister.do")
    public String stuRegister(Student student){
        int result=studentService.insertStudent(student);

        return null;
    }
    /*
        function:删除学生信息
     */
    @RequestMapping("/stuDelete.do")
    public String stuDelete(String stuId) {
        int result=studentService.deleteStudent(stuId);

        return null;
    }
    /*
        function:修改学生信息
     */
    @RequestMapping("/stuUpdate.do")
    public String stuUpdate(Entity<Student> entity) {
        int result=studentService.updateStudent(entity);
        return null;
    }
    /*
        function:查询学生信息
     */
    @RequestMapping("/stuQuery.do")
    public String stuQueryById(HttpServletRequest request) {
        return null;
    }
    @RequestMapping("/queryByName")
    public String stuQueryByName(HttpServletRequest request) {
        return null;
    }


    /*
    function:学生登录
    @return:返回视图名
 */
    @RequestMapping("/stuLogin.do")
    public String stuLogin(HttpServletRequest request) {
        return null;
    }
    /*
        function:修改密码
     */
    @RequestMapping("/stuModifyPass.do")
    public String modifyPasswords(HttpServletRequest request) {
        return null;
    }
}
