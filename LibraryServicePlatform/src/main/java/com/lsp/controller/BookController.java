package com.lsp.controller;

import com.lsp.domain.Book;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.BookService;
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

    @RequestMapping("/bookAdd.do")
    public String bookAdd(Book book) {
        int result=bookService.insertBook(book);
        return null;
    }

    @RequestMapping("/bookDelete.do")
    public String bookDelete(String bookId) {
        int result=bookService.deleteBook(bookId);
        return null;
    }

    @RequestMapping("/bookUpdate.do")
    public String bookUpdate(Entity<Book> entity) {
        int reslut=bookService.updateBook(entity);
        return null;
    }

//    @RequestMapping("/bookQuery")
//    public ModelAndView bookQuery(String queryCondition) {        //查询书籍，包括书号，书名，书作者的精确查询和它们的模糊查询
//        BookService bookService=(BookService)applicationContext.getBean("bookServiceImpl");
//        List<Book> list=bookService.findBooks(queryCondition);      //返回的书籍可能有多本，故用集合来接受
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("");       //该值以后填写
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }
//
//    //书籍分类
//    @RequestMapping("/bookQueryByHot")
//    public ModelAndView bookQueryByHot(String hot) {
//        BookService bookService=(BookService)applicationContext.getBean("bookServiceImpl");
//        List<Book> list=bookService.sortBooksByHot();
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("");       //该值以后填写
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }
//    @RequestMapping("/bookQueryByClassify")
//    public ModelAndView bookQueryByClassify(String classify) {
//        BookService bookService=(BookService)applicationContext.getBean("bookServiceImpl");
//        List<Book> list=bookService.sortBookByClassify();
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("");       //该值以后填写
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }
}
