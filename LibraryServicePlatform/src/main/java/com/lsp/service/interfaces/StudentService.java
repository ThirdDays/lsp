package com.lsp.service.interfaces;

import com.lsp.domain.Student;
import com.lsp.domain.complex.Entity;

public interface StudentService {
    public int insertStudent(Student student);
    public int deleteStudent(String stuId);
    public int updateStudent(Entity<Student> entity);

    public Student findStudentById(String stuId);
    public Student findStudentByName(String stuName);

    public boolean login(String stuId,String passwords);    //登录
    public boolean modifyPasswords(String stuId,String newPasswords);       //修改密码
}
