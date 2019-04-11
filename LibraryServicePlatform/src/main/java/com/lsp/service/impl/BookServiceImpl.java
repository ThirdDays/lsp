package com.lsp.service.impl;

import com.lsp.dao.BookDAO;
import com.lsp.domain.Book;
import com.lsp.domain.BookTest;
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

    @Override
    public List<Book> findBook(String queryCondition) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.findBook(queryCondition);
        return list;
    }

    @Override
    public Book findBookById(String bId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        Book book=bookDAO.findBookById("123");
        return book;
    }

    @Override
    public Book findBookByName(String bookName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        Book book=bookDAO.findBookByName(bookName);
        return book;
    }

    @Override
    public Book findBookByAuthor(String author) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        Book book=bookDAO.findBookByAuthor(author);
        return book;
    }

    @Override
    public List<Book> findBookByType(String classify) {     //通过分类来查询书籍
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.findBookByType(classify);
        return list;
    }

    @Override
    public List<Book> blurFindBookByName(String bookName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.blurFindBookByName(bookName);
        return list;
    }

    @Override
    public List<Book> blurFindBookByAuthor(String author) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.blurFindBookByAuthor(author);
        return list;
    }

    @Override
    public List<Book> sortBookByHot() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.sortBookByHot();
        return list;
    }

    @Override
    public List<Book> findAllBooks() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<Book> list=bookDAO.findAllBooks();
        return list;
    }


    @Override
    public List<BookTest> resultMapTest(String bookId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookDAO bookDAO=sqlSession.getMapper(BookDAO.class);
        List<BookTest> list=bookDAO.resultMapTest(bookId);
        return list;
    }
}
