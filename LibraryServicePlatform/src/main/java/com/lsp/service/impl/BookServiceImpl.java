package com.lsp.service.impl;

import com.lsp.dao.BookDAO;
import com.lsp.domain.po.Book;
import com.lsp.domain.complex.Entity;
import com.lsp.service.interfaces.BookService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public int insertBook(Book book) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        int result=bookDAO.insertBook(book);
        return result;
    }
    @Override
    public int deleteBook(String bookId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        int result=bookDAO.deleteBook(bookId);
        return result;
    }
    @Override
    public int updateBook(Entity<Book> entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        int result=bookDAO.updateBook(entity);
        return result;
    }


    //单本查询
    @Override
    public Book findBookById(String bId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        Book book=bookDAO.findBookById(bId);
        return book;
    }


    //通过输入框输入的文本进行查询，可能查到多本。该方法可能会通过书名，作者等来模糊查询
    @Override
    public List<Book> findBooksByText(String queryCondition) {      //总的模糊查询
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.findBooksByText(queryCondition);
        return list;
    }

    //多本查询
    @Override
    public List<Book> findBooksByType(String classify) {     //通过书籍分类（类别）来查询书籍
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.findBooksByType(classify);
        return list;
    }
    @Override
    public List<Book> sortBooksByHot() {                             //通过热点来排序书籍
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.sortBooksByHot();
        return list;
    }

    @Override
    public List<Book> findAllBooks() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.findAllBooks();
        return list;
    }


//    @Override
//    public List<Book> blurFindBookByName(String bookName) {
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
//        List<Book> list=bookDAO.blurFindBookByName(bookName);
//        return list;
//    }
//
//    @Override
//    public List<Book> blurFindBookByAuthor(String author) {
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
//        List<Book> list=bookDAO.blurFindBookByAuthor(author);
//        return list;
//    }
//    @Override
//    public Book findBookByName(String bookName) {
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
//        Book book=bookDAO.findBookByName(bookName);
//        return book;
//    }
//    @Override
//    public Book findBookByAuthor(String author) {                    //通过作者查询书籍
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
//        Book book=bookDAO.findBookByAuthor(author);
//        return book;
//    }
//    @Override
//    public List<BookTest> resultMapTest(String bookId) {
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
//        List<BookTest> list=bookDAO.resultMapTest(bookId);
//        return list;
//    }
}
