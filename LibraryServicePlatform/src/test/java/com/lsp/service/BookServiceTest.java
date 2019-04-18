package com.lsp.service;

import com.lsp.domain.po.Book;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookServiceTest {

    private int result;
    private ApplicationContext applicationContext;
    private BookService bookService;
    @Before
    public void init() {
        System.out.println("init!");
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        bookService=(BookService)applicationContext.getBean("bookServiceImpl");
    }
    @Test
    public void insertBookTest() {
        Book book =new Book();
        book.setBookId("5674");
        book.setBookName("Mybatis");
        book.setAuthor("bob");
        book.setCategory("computer");
        book.setHot(23);
        book.setLocation("location");
        result=bookService.insertBook(book);
        System.out.println("insertBookTest");
    }
    @Test
    public void deleteBookTest() {
        result=bookService.deleteBook("456");
        System.out.println("deleteBookTest");
    }
    @Test
    public void updateBookTest() {
        Entity<Book> entity=new Entity<>();
        Book book=new Book();
        book.setBookId("234");
        book.setBookName("ksjdf");
        book.setStatus(1);
        entity.setId("123");
        entity.setObject(book);
        result=bookService.updateBook(entity);
        System.out.println("updateBookTest");
    }

    @Test
    public void findBookByIdTest() {
        Book book=bookService.findBookById("987");
        System.out.println(book);
        System.out.println("findBookByIdTest!");
    }
    @Test
    public void findBooksByTextTest() {
        List<Book> list=bookService.findBooksByText("i");
        for(Book book:list) {
            System.out.println(book);
        }
        System.out.println("findBooksByTextTest!");
    }

    @Test
    public void findBookByTypeTest() {
        List<Book> list=bookService.findBooksByType("computer");
        for(Book book:list) {
            System.out.println(book);
        }
        System.out.println("findBookByTypeTest!");
    }

    @Test
    public void sortBookByHotTest() {
        List<Book> list=bookService.sortBooksByHot();
        for(Book book:list) {
            System.out.println(book);
        }
        System.out.println("sortBookByHotTest");
    }

    @Test
    public void findAllBooksTest() {
        List<Book> list=bookService.findAllBooks();
        for(Book book:list) {
            System.out.println(book);
        }
        System.out.println("findAllBooksTest!");
    }


    @After
    public void end() {
        System.out.println(result);
        System.out.println("end!");
    }


    //    @Test
//    public void findBookByNameTest() {
//        Book book=bookService.findBookByName("book");
//        System.out.println(book);
//        System.out.println("findBookByNameTest!");
//    }
//    @Test
//    public void findBookByAuthorTest() {
//        Book book=bookService.findBookByAuthor("tom");
//        System.out.println(book);
//        System.out.println("findBookByAuthorTest!");
//    }
    //    @Test
//    public void resultMapTest() {
//        List<BookTest> list=bookService.resultMapTest("789");
//        for(BookTest book:list) {
//            System.out.println(book);
//        }
//        System.out.println("result:resultMapTest!");
//    }
//    @Test
//    public void blurFindBookByNameTest() {
//        List<Book> list=bookService.blurFindBookByName("i");
//        for(Book book:list) {
//            System.out.println(book);
//        }
//        System.out.println("blurFindBookByNameTest!");
//    }
//    @Test
//    public void blurFindBookByAuthorTest() {
//        List<Book> list=bookService.blurFindBookByAuthor("o");
//        for(Book book:list) {
//            System.out.println(book);
//        }
//        System.out.println("blurFindBookByAuthorTest!");
}
