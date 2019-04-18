package com.lsp.dao;

import com.lsp.domain.po.Student;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;

/*
    学生接口
 */
public interface StudentDAO{
    /*
        function:添加学生信息
        @param:学生信息的封装类对象
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int insertStudent(Student student);   //添加学生信息
    /*
        function:删除学生信息
        @param:学生id
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int deleteStudent(String stuId);
    /*
        function:更新学生信息
        @param:学生更新信息的封装类对象
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int updateStudent(Entity<Student> entity);
    /*
        function:通过学生id查询学生信息
        @param:学生id
        @return:学生信息的封装类对象
    */
    public Student findStudentById(String stuId);
    /*
        function:通过学生姓名查询信息
        @param:学生姓名
        @return:学生信息的封装类对象
     */
    public Student findStudentByName(String stuName);

    public String findPasswords(String stuId);      //查询密码
    public int modifyPasswords(ServiceToDAOVO serviceToDAOVO);   //修改密码
}
