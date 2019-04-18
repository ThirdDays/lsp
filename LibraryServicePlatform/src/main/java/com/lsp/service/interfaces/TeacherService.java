package com.lsp.service.interfaces;

import com.lsp.domain.po.Teacher;
import com.lsp.domain.complex.Entity;

public interface TeacherService  {
    public int insertTeacher(Teacher teacher);
    public int deleteTeacher(String tId);
    public int updateTeacher(Entity<Teacher> entity);

    public Teacher findTeacherById(String tId);
    public Teacher findTeacherByName(String tName);

    public boolean login(String tId,String passwords);      //登录
    public boolean modifyPasswords(String tId,String newPasswords); //修改密码
}
