package com.lsp.service;

import com.lsp.domain.Admin;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminServiceTest {

    private ApplicationContext applicationContext;
    private AdminService adminService;
    @Before
    public void init() {
       applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        adminService=(AdminService)applicationContext.getBean("adminServiceImpl");
//        this.sqlSessionFactory=(SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
    }
    @Test
    public void insertAdminTest() {
        //模拟数据
        Admin admin=new Admin();
        admin.setaId("123");
        admin.setaName("tom");
        admin.setPasswords("123456");

        int result=adminService.insertAdmin(admin);
        System.out.println(result);
        System.out.println("insertAdminTest");
    }

    @Test
    public void deleteAdminByIdTest() {
        int result=adminService.deleteAdminById("456");
        System.out.println(result);
        System.out.println("deleteAdminByIdTest!");
    }

    @Test
    public void updateAdminTest() {
        Entity<Admin> entity=new Entity<>();
        entity.setId("123");
        Admin admin=new Admin();
        admin.setaId("456");
        admin.setaName("bob");
        admin.setPasswords("12345678");
        entity.setObject(admin);
        int result=adminService.updateAdmin(entity);
        System.out.println(result);
        System.out.println("updateAdmin!");
    }
    @Test
    public void findAdminByIdTest() {
        Admin admin=adminService.findAdminById("123");
        System.out.println(admin);
        System.out.println("findAdminByIdTest");
    }
    @Test
    public void findAdminByNameTest() {
        Admin admin=adminService.findAdminByName("tom");
        System.out.println(admin);
        System.out.println("findAdminByNameTest");
    }
    @Test
    public void login() {
        boolean bool=adminService.login("123","123456");
        System.out.println(bool);
        System.out.println("login!");
    }
    @Test
    public void modifyPasswords() {
        boolean bool=adminService.modifyPasswords("123","abc123432");
        System.out.println(bool);
        System.out.println("modifyPasswords");
    }
}

