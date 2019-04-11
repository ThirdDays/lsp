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
    @Test
    public void loadBookTest() {
        Date date = new Date();
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
//        System.out.println(timestamp);
        boolean bool=borrowService.loadBook("123","456",timestamp);
        System.out.println(bool);
        System.out.println("loadBookTest!");
    }

    @Test
    public void returnBookTest() {
        boolean bool=borrowService.returnBook("123","456");
        System.out.println(bool);
        System.out.println("returnBookTest!");
    }
//    @After
    public void end() {
        System.out.println(result);
        System.out.println("end!");
    }
}
