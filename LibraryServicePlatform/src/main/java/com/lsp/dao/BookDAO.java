package com.lsp.dao;

import com.lsp.domain.Book;
import com.lsp.domain.BookTest;
import com.lsp.domain.complex.Entity;

import java.util.List;

/*
    图书接口,该接口中有一些图书自身的基本操作方法和一些高级操作方法
 */
public interface BookDAO{

    public int insertBook(Book book);
    //删除书籍信息
    public int deleteBook(String bookId);
    //更新书籍信息
    public int updateBook(Entity<Book> entity);

    public List<Book> findBook(String queryCondition);   //书籍查询的统一入口
    //单本查询
    public Book findBookById(String bId);
    public Book findBookByName(String bookName);    //通过书名来查找
    public Book findBookByAuthor(String author);        //通过作者来查询
    //多本查询
    public List<Book> findBookByType(String type);
    public List<Book> findAllBooks();       //查询所有书籍
    //模糊查询
    public List<Book> blurFindBookByName(String bookName);    //通过书名来查找书籍
    public List<Book> blurFindBookByAuthor(String author);

    //排序书籍
    public List<Book> sortBookByHot();         //通过热度（也就是借阅量）来排序图书

//    测试方法
    public List<BookTest> resultMapTest(String bookId);
}
