package com.lsp.controller;

import com.lsp.domain.po.Borrow;
import com.lsp.service.interfaces.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    /*
        function:借阅书籍
     */
    @RequestMapping("/borrowBook.do")
    public String borrowBook(String userId, String bookId, String term,HttpServletRequest request) {
//        long longTime = term.getTime();
//        Timestamp term2 = new Timestamp(longTime);
        boolean bool=borrowService.loadBook(userId,bookId,term);
        if(bool) {  //借阅成功
            request.setAttribute("msg","操作成功！");
            System.out.println("borrow successfu!");
            return "jsp/custom_service/borrowBook.jsp";
        }
        request.setAttribute("msg","操作失败！");
        System.out.println("borrow failed");
        return "jsp/custom_service/borrowBook.jsp";
    }
    /*
        function:还书
     */
    @RequestMapping("/returnBook.do")
    public String returnBook(String userId,String bookId,HttpServletRequest request) {
        boolean bool = borrowService.returnBook(userId,bookId);
        if(bool) {
            request.setAttribute("msg","操作成功！");
            System.out.println("return successfu!");
            return "jsp/custom_service/returnBook.jsp";
        }
        request.setAttribute("msg","操作失败！");
        System.out.println("return failed");
        return "jsp/custom_service/returnBook.jsp";
    }

    @RequestMapping("/queryBorrowNotBeReturnedButOverdueRecord.do")
    public ModelAndView queryBorrowNotBeReturnedButOverdueRecord() {         //这是查看借阅记录的公共方法，用于查看所有的记录
        List<Borrow> list = borrowService.queryBorrowNotBeReturnedButOverdueRecord();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/common/queryBorrowRecord.jsp");
        modelAndView.addObject("borrowList",list);
        return modelAndView;
    }

    @RequestMapping("/queryUserBorrowRecord.do")
    public ModelAndView queryUserBorrowRecord(String id) { ;
        List<Borrow> list = borrowService.queryUserBorrowRecord(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/common/queryBorrowRecord.jsp");
        modelAndView.addObject("borrowList",list);
        return modelAndView;
    }
}
