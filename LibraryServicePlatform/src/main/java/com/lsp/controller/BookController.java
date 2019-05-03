package com.lsp.controller;

import com.lsp.domain.po.Book;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping("/addBook.do")
    public String addBook(Book book,HttpServletRequest request) {
        int result=bookService.insertBook(book);
        if(result > 0) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/addBook.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/addBook.jsp";
    }

    @RequestMapping("/deleteBook.do")
    public String deleteBook(String bookId,HttpServletRequest request) {
        int result=bookService.deleteBook(bookId);
        if(result > 0) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/deleteBook.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/deleteBook.jsp";
    }

    @RequestMapping("/modifyBook.do")
    public String modifyBook(Entity<Book> entity,HttpServletRequest request) {
        int result=bookService.updateBook(entity);
        if(result > 0) {
            request.setAttribute("msg","操作成功！");
            return "jsp/admin/modifyBook.jsp";
        }
        request.setAttribute("msg","操作失败！");
        return "jsp/admin/modifyBook.jsp";
    }

    @RequestMapping("/queryBook.do")
    public ModelAndView queryBook(String queryCondition) {            //这是一个总的书籍查询接口，所有的查询都通过此方法来进行（查看热门书籍外）
        List<Book> list = bookService.findBooksByText(queryCondition);
//        for(Book book:list) {
//            System.out.println(book);
//        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/common/queryBook.jsp");
        modelAndView.addObject("bookList",list);
//        request.setAttribute("bookList",list);
        System.out.println("this is queryBook!");
        return modelAndView;
    }

    @RequestMapping("/queryHotBook.do")
    public ModelAndView queryHotBook() {          //查看热门书籍
//        System.out.println("this is queryHotBook!");
        List<Book> list = bookService.sortBooksByHot();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/common/queryHotBook.jsp");
        modelAndView.addObject("bookList",list);
        return modelAndView;
//        return "jsp/common/queryHotBook";
    }

//    //按查询条件来查询书籍，即从输入框中输入
//    @RequestMapping("/bookQuery")
//    public ModelAndView bookQuery(String queryCondition) {        //查询书籍，包括书号，书名，书作者的精确查询和它们的模糊查询
//        List<Book> list=bookService.findBooks(queryCondition);      //返回的书籍可能有多本，故用集合来接受
//
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("");       //该值以后填写
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }
//
//    //书籍分类
//    @RequestMapping("/bookQueryByHot")
//    public ModelAndView bookQueryByHot(String hot) {
////        BookService bookService=(BookService)applicationContext.getBean("bookServiceImpl");
//        List<Book> list=bookService.sortBookByHot();
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("");       //该值以后填写
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }
//    @RequestMapping("/bookQueryByClassify")
//    public ModelAndView bookQueryByClassify(String classify) {          //通过书籍的类别（分类）来查询
//        BookService bookService=(BookService)applicationContext.getBean("bookServiceImpl");
//        List<Book> list=bookService.findBookByType(classify);           //通过分类来查询
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("");       //该值以后填写
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }
}
