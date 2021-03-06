package com.lsp.service;

import com.lsp.domain.po.Teacher;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.TeacherService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeacherServiceTest {

    private int result;
    private ApplicationContext applicationContext;
    private TeacherService teacherService;
    @Before
    public void init() {
        System.out.println("init!");
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        teacherService=(TeacherService)applicationContext.getBean("teacherServiceImpl");
    }
    @Test
    public void insertTeacherTest() {
        Teacher teacher=new Teacher();
        teacher.setTeachId("123");
        teacher.setTeachName("teacher");
        teacher.setPasswords("123456");
        result=teacherService.insertTeacher(teacher);
        System.out.println("insertTeacherTest");
    }
    @Test
    public void deleteTeacherTest() {
        result=teacherService.deleteTeacher("123");
        System.out.println("deleteTeacherTest");
    }
    @Test
    public void updateTeacherTest() {
        Entity<Teacher> entity=new Entity<>();
        Teacher teacher=new Teacher();
        teacher.setTeachId("456");
        teacher.setTeachName("name");
        teacher.setPasswords("sdjfie");
        teacher.setBalances(23.324f);
        entity.setId("123");
        entity.setObject(teacher);
        result=teacherService.updateTeacher(entity);
        System.out.println("updateTeacherTest");
    }
    @Test
    public void findTeacherByIdTest() {
        Teacher teacher=teacherService.findTeacherById("123");
        System.out.println(teacher);
        System.out.println("findTeacherByIdTest!");
    }
    @Test
    public void findTeacherByNameTest() {
        Teacher teacher=teacherService.findTeacherByName("teacher");
        System.out.println(teacher);
        System.out.println("findTeacherByNameTest!");
    }
    @Test
    public void loginTest() {
        boolean bool=teacherService.login("123","123456");
        System.out.println(bool);
        System.out.println("loginTest");
    }
    @Test
    public void modifyPasswordsTest() {
        boolean bool=teacherService.modifyPasswords("123","abc123");
        System.out.println(bool);
        System.out.println("modifyPasswordsTest");
    }
    @After
    public void end() {
        System.out.println(result);
        System.out.println("end!");
    }
}
