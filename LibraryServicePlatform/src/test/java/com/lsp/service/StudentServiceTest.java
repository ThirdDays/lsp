package com.lsp.service;

import com.lsp.domain.Student;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest {

    private int result;
    private ApplicationContext applicationContext;
    private StudentService studentService;
    @Before
    public void init() {
        System.out.println("init!");
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        studentService=(StudentService)applicationContext.getBean("studentServiceImpl");
    }
    @Test
    public void insertStudentTest() {
        Student student=new Student();
        student.setStuId("123");
        student.setStuName("stu");
        student.setPasswords("123456");
        result=studentService.insertStudent(student);
    }
    @Test
    public void deleteStudentTest() {
        result=studentService.deleteStudent("456");
    }
    @Test
    public void updateStudentTest() {
        Entity<Student> entity=new Entity<>();
        Student student=new Student();
        student.setStuId("456");
        student.setStuName("student");
        student.setPasswords("sdfjiwe");
        entity.setId("123");
        entity.setObject(student);
        result=studentService.updateStudent(entity);
    }
    @Test
    public void findStudentByIdTest() {
        Student student=studentService.findStudentById("123");
        System.out.println(student);
        System.out.println("findStudentByIdTest");
    }
    @Test
    public void findStudentByNameTest() {
        Student student=studentService.findStudentByName("student");
        System.out.println(student);
        System.out.println("findStudentByNameTest");
    }
    @Test
    public void loginTest() {
        boolean bool=studentService.login("123","123456");
        System.out.println(bool);
        System.out.println("loginTest!");
    }
    @Test
    public void modifyPasswords() {
        boolean bool=studentService.modifyPasswords("123","skdjfi");
        System.out.println(bool);
        System.out.println("modifyPasswords!");
    }
    @After
    public void end() {
        System.out.println(result);
        System.out.println("end!");
    }
}
