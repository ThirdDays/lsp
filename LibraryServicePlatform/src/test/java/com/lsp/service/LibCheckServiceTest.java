package com.lsp.service;

import com.lsp.service.interfaces.BorrowService;
import com.lsp.service.interfaces.LibCheckService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibCheckServiceTest {
    private ApplicationContext applicationContext;
    private LibCheckService libCheckService;
    @Before
    public void init() {
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        libCheckService=(LibCheckService)applicationContext.getBean("libCheckServiceImpl");
    }
    @Test
    public void checkUserTest() {
        boolean bool=libCheckService.checkUser("123");
        System.out.println(bool);
        System.out.println("checkUserTest");
    }
}
