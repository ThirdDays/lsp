package com.lsp.service.interfaces;

import com.lsp.domain.Book;
import com.lsp.domain.BookTest;
import com.lsp.domain.complex.Entity;

import java.util.List;

public interface BookService {

    public int insertBook(Book book);
    public int deleteBook(String bookId);
    public int updateBook(Entity<Book> entity);

    public List<Book> findBook(String queryCondition);
    //单本查询
    public Book findBookById(String bId);
    public Book findBookByName(String bookName);
    public Book findBookByAuthor(String author);

    //多本查询
    public List<Book> findBookByType(String type);  //通过分类来排序书籍
    public List<Book> blurFindBookByName(String bookName);
    public List<Book> blurFindBookByAuthor(String author);
    //排序书籍
    public List<Book> sortBookByHot();      //通过热点（借阅量）来排序书籍

    public List<Book> findAllBooks();       //查找全部书籍


    public List<BookTest> resultMapTest(String bookId); //测试方法
}
