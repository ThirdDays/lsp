package com.lsp.service.interfaces;

import com.lsp.domain.po.Book;
import com.lsp.domain.complex.Entity;

import java.util.List;

public interface BookService {

    public int insertBook(Book book);
    public int deleteBook(String bookId);
    public int updateBook(Entity<Book> entity);



    //单本查询
    public Book findBookById(String bId);           //精准查询

    //通过输入框输入的文本进行查询，可能查到多本。该方法可能会通过书名，作者等来模糊查询
    public List<Book> findBooksByText(String queryCondition);                  //模糊查询

    //通过选择条件来查询书籍
    public List<Book> findBooksByType(String type);  //通过分类来排序书籍
    //排序书籍
    public List<Book> sortBooksByHot();      //通过热点（借阅量）来排序书籍

    public List<Book> findAllBooks();       //查找全部书籍


//    public Book findBookByName(String bookName);
//    public Book findBookByAuthor(String author);

    //多本查询

//    public List<Book> blurFindBookByName(String bookName);  //通过书名查询
//    public List<Book> blurFindBookByAuthor(String author);  //通过作者来查询
    //总的模糊查询
//    public List<Book> findBooks(String queryCondition);


//    public List<BookTest> resultMapTest(String bookId); //测试方法
}
