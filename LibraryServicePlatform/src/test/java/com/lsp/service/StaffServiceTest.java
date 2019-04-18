package com.lsp.service;

import com.lsp.domain.po.Staff;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.StaffService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

public class StaffServiceTest {

    private ApplicationContext applicationContext;
    private StaffService staffService;
    int result;
    @Before
    public void init(){
        System.out.println("start!");
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        staffService=(StaffService)applicationContext.getBean("staffServiceImpl");
        System.out.println("init!");
    }
    @Test
    public void insertStaffTest() {
        Staff staff=new Staff();
        staff.setStaffId("123");
        staff.setStaffName("staff");
        staff.setPasswords("123456");
        result=staffService.insertStaff(staff);
//        System.out.println(result);
        System.out.println("insertStaffTest");
    }
    @Test
    public void deleteStaffTest() {
        result=staffService.deleteStaff("123");
//        System.out.println(result);
        System.out.println("deleteStaffTest");
    }
    @Test
    public void updateStaffTest() {
        Entity<Staff> entity=new Entity<>();
        entity.setId("123");
        Staff staff=new Staff();
        staff.setStaffId("456");
        staff.setStaffName("staffes");
        staff.setPasswords("135ksjdfie");
        entity.setObject(staff);
        result=staffService.updateStaff(entity);
//        System.out.println(result);
        System.out.println("updateStaffTest");
    }
    @Test
    public void findStaffByIdTest() {
        Staff staff=staffService.findStaffById("123");
        System.out.println(staff);
        System.out.println("findStaffByIdTest!");
    }
    @Test
    public void findStaffByNameTest() {
        Staff staff=staffService.findStaffByName("staff");
        System.out.println(staff);
        System.out.println("findStaffByNameTest!");
    }
    @Test
    public void loginTest() {
        boolean bool=staffService.login("123","123456");
        System.out.println(bool);
        System.out.println("loginTest");
    }
    @Test
    public void modifyPasswordsTest() {
        boolean bool=staffService.modifyPasswords("123","abc123");
        System.out.println(bool);
        System.out.println("modifyPasswordsTest");
    }
    @Test
    public void sign() {
        String staffId = "123";
        String result = staffService.sign(staffId);
        System.out.println(result);
        System.out.println("sign");
    }
//    @After
    public void end() {
        System.out.println(result);
        System.out.println("end!");
    }
}
