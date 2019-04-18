package com.lsp.service;

import com.lsp.service.interfaces.BorrowService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BorrowServiceTest {

    private ApplicationContext applicationContext;
//    @Autowired
    private BorrowService borrowService;
    int result;
    @Before
    public void init() {
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        borrowService=(BorrowService)applicationContext.getBean("borrowServiceImpl");
    }
    //获取系统当前时间
    public String getNowTime() {
        //获取系统当前时间
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        String nowTime = dateFormat.format(date);
        return nowTime;
    }

    @Test
    public void loadBookTest() {
        boolean bool=borrowService.loadBook("345","5674","2019-04-17 10:10:10");
//        borrowService.
        System.out.println(bool);

        System.out.println("loadBookTest!");
    }

    @Test
    public void returnBookTest() {
        boolean bool=borrowService.returnBook("345","5674");
        System.out.println(bool);
        System.out.println("returnBookTest!");
    }
//    @After
    public void end() {
        System.out.println(result);
        System.out.println("end!");
    }
}
