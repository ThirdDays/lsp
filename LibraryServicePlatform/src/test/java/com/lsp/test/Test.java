package com.lsp.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    @org.junit.Test
    public void test() throws Exception{
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-4-15 17:44:28");

//        System.out.println(date);
        String now = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(date);
//
        System.out.println(now);
    }
}
