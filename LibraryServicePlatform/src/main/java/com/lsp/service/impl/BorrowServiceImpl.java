package com.lsp.service.impl;

import com.lsp.dao.BorrowDAO;
import com.lsp.domain.LoadBook;
import com.lsp.domain.vo.SetBookStatus;
import com.lsp.service.interfaces.BorrowService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public boolean checkIdentifier(String identifier) {     //验证借阅人的身份
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        String id=borrowDAO.queryIdentifier(identifier);
        if(id==null) {      //借阅人不存在
            return false;
        }
        return true;
    }

    public boolean checkBookId(String bookId) {         //验证所借书籍是存在
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        String id=borrowDAO.findBookId(bookId);
        if(id.equals(bookId)) {     //所借阅书籍存在
            return true;
        }
        return false;
    }

    public boolean isFree(String bookId) {          //检查所借书籍是否空闲
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        int status=borrowDAO.findStatus(bookId);
        if(status==0) {         //所借阅书籍空闲
            return true;
        }
        return false;
    }

    public LoadBook pot(String identifier, String bookId, Timestamp term) {
        LoadBook loadBook=new LoadBook();
        loadBook.setIdentifier(identifier);    //设置借书人
        loadBook.setBookId(bookId);        //设置借阅书籍的书号
        Date date = new Date();
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
        loadBook.setBorrowTime(timestamp);     //设置借阅时间
        loadBook.setTerm(term);   //设置还书期限
        return loadBook;
    }
    @Override
    public boolean loadBook(String identifier, String bookId, Timestamp term) {
        /*
               1.验证借阅人的身份，如果身份不正确，则借阅失败！
               2.验证所借阅书籍的书号，如果不正确则借阅失败！
               3.如果借阅人的身份和所借书籍的书号都正确则执行下一步！
         */
        /*
               1.查看所借阅书籍的状态，0表示空闲，1表示已被借阅。
               2.如果所借阅书籍的状态为1，则借阅失败！
               3.如果所借阅书籍的状态为0，执行下一步！
                 查看借阅人的过往借阅记录
                    如果是第一次借书则执行借书操作！
                    如果不是第一次借阅，则查看借阅人的借阅历史：
                        如果发现还有借阅过的书还没有还，则借阅失败！
                        如果发现有借阅过但已还书，则执行借阅操作！
         */
        if(checkIdentifier(identifier)==false||checkBookId(bookId)==false) {        //借阅人不存在或书籍不存在
            return false;
        }
        if(isFree(bookId)==false) {     //所借阅书籍被已被借走
            return false;
        }
        System.out.println("start!");
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        LoadBook loadBook=borrowDAO.queryLastRecord(identifier);
        if(loadBook==null) {    //之前没有过借阅记录
            LoadBook loadBook1=pot(identifier,bookId,term);
            borrowDAO.insertBorrow(loadBook1);     //插入借阅记录
            SetBookStatus setBookStatus=new SetBookStatus();
            setBookStatus.setbId(bookId);
            setBookStatus.setStatus(1);
            borrowDAO.setBookStatus(setBookStatus);
            return true;
        }else {
            Timestamp returnTime=loadBook.getReturnTime();   //获取上一次还书时间
            if(returnTime!=null) {
                borrowDAO.insertBorrow(pot(identifier,bookId,term));   //执行借书操作
                return true;
            }
            return false;       //没有还书
        }
    }

    public LoadBook potReturn(String identifier, String bookId) {
        Date date = new Date();
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
        LoadBook loadBook=new LoadBook();
        loadBook.setIdentifier(identifier);
        loadBook.setBookId(bookId);
        loadBook.setReturnTime(timestamp);
        return loadBook;
    }
    @Override
    public boolean returnBook(String identifier, String bookId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        int result=borrowDAO.updateBorrow(potReturn(identifier,bookId));
        if(result>0) {
            SetBookStatus setBookStatus=new SetBookStatus();
            setBookStatus.setbId(bookId);
            setBookStatus.setStatus(0);
            borrowDAO.setBookStatus(setBookStatus);
            return true;
        }
        return false;
    }
}