package com.lsp.dao;

import com.lsp.domain.po.Teacher;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;

public interface TeacherDAO {
    /*
        function:添加教师信息
        @param:教师信息的封装类对象
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int insertTeacher(Teacher teacher);   //添加学生信息
    /*
        function:删除教师信息
        @param:教师id
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int deleteTeacher(String tId);
    /*
        function:更新教师信息
        @param:教师更新信息的封装类对象
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int updateTeacher(Entity<Teacher> entity);
    /*
        function:通过教师id查询学生信息
        @param:教师id
        @return:教师信息的封装类对象
    */
    public Teacher findTeacherById(String tId);
    /*
        function:通过教师姓名查询信息
        @param:教师姓名
        @return:教师信息的封装类对象
     */
    public Teacher findTeacherByName(String name);

    public String findPasswords(String tId);    //查询密码
    public int modifyPasswords(ServiceToDAOVO serviceToDAOVO);  //修改密码

}
