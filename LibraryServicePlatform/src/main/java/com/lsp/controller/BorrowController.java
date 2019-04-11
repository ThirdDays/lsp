package com.lsp.controller;

import com.lsp.service.interfaces.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/load")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    /*
        function:借阅书籍
     */
    @RequestMapping("/loadBook.do")
    public String loadBook(String identifier, String bookId, Date term) {
        long longTime = term.getTime();
        Timestamp term2 = new Timestamp(longTime);
        boolean bool=borrowService.loadBook(identifier,bookId,term2);
        if(bool) {  //借阅成功

        }
        return null;
    }
    /*
        function:还书
     */
    @RequestMapping("/returnBook.do")
    public String returnBook(String identifier,String[] bookIds) {
        return null;
    }
}
