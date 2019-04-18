package com.lsp.service.impl;

import com.lsp.dao.BorrowDAO;
import com.lsp.domain.LoadBook;
import com.lsp.domain.po.Borrow;
import com.lsp.domain.vo.SetBookStatus;
import com.lsp.service.interfaces.BorrowService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /*
         核心借阅操作步骤如下:
              1.验证借阅人和书号是否合法（即是否正确）
              2.检查借阅书籍的状态是否已被占用
              3.检查借阅人的历史借阅记录中是否有借书但仍未归还
              核心操作
              4.设置所借阅书籍的状态为已占用以表示借阅该书同时防止其他人再借
              5.插入借阅时间和借阅期限，也就是借阅记录
    */
    @Override
    public boolean loadBook(String userId, String bookId, String term) {        //规定一次只能借一本
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        //验证输入数据的合法性
        if(this.checkIdentifier(borrowDAO,userId)==false || this.checkBookId(borrowDAO,bookId)==false) {        //借阅人不存在或书籍不存在
            return false;
        }
        //检查所借阅书籍是否空闲
        if(this.isBookFree(borrowDAO,bookId)==false) {     //所借阅书籍被已被借走
            return false;
        }
        //借阅人借书未还，限制一次只能借一本书
        if(this.isBookNotBeReturned(borrowDAO,userId)) {            //借阅人借书未还
            return false;
        }
        //执行借阅操作
        int sign = this.setBookStatus(borrowDAO,bookId,1);          ////设置所借书籍的状态为已被占用
        int result = this.insertBorrow(borrowDAO,userId,bookId,term);       //插入借阅记录

        if(result <= 0 || sign <= 0) {               //插入失败
            return false;
        }
        return  true;
    }

    /*
        还书的操作步骤如下：
          1.设置书籍的状态为0，即空闲
          2.记录还书的时间
   */
    @Override
    public boolean returnBook(String userId, String bookId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        if(this.checkIdentifier(borrowDAO,userId)==false || this.checkBookId(borrowDAO,bookId)==false) {        //借阅人不存在或书籍不存在
            return false;
        }

        //设置书籍的状态为空闲
        int result = this.setBookStatus(borrowDAO,bookId,0);
        //记录还书时间
        int sign = this.setReturnBookTime(borrowDAO,userId,bookId);               //记录还书时间

        if(result > 0 && sign > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Borrow> queryBorrowNotBeReturnedButOverdueRecord() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        List<Borrow> list = borrowDAO.queryBorrowNotBeReturnedButOverdueRecord();
        return list;
    }

    @Override
    public List<Borrow> queryUserBorrowRecord(String userId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BorrowDAO borrowDAO=sqlSession.getMapper(BorrowDAO.class);
        List<Borrow> list = borrowDAO.queryUserBorrowRecord(userId);
        return list;
    }

    public boolean checkIdentifier(BorrowDAO borrowDAO, String identifier) {     //验证借阅人的身份
        String id=borrowDAO.queryIdentifier(identifier);
        if(id==null) {      //借阅人不存在
            return false;
        }
        return true;
    }

    public boolean checkBookId(BorrowDAO borrowDAO,String bookId) {         //验证所借书籍是存在
        String id=borrowDAO.findBookId(bookId);
        if(id.equals(bookId)) {     //所借阅书籍存在
            return true;
        }
        return false;
    }

    public boolean isBookFree(BorrowDAO borrowDAO,String bookId) {          //检查所借书籍是否空闲
        int status=borrowDAO.getBookStatus(bookId);
        if(status==0) {         //所借阅书籍空闲
            return true;
        }
        return false;
    }

    public boolean isBookNotBeReturned(BorrowDAO borrowDAO,String userId) {        //借阅人借书未还
        List<Borrow> list = borrowDAO.getBookNotBeReturnedBorrow(userId);               //获取未还书记录
        if(list.size() > 0) {                  //借阅人借书未还
            return true;
        }
        return false;                   //没有借书未还记录或是第一次借书
    }

    //获取系统当前时间
    public String getNowTime() {
        //获取系统当前时间
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        String nowTime = dateFormat.format(date);
        return nowTime;
    }

    //设置书籍的状态
    public int setBookStatus(BorrowDAO borrowDAO,String bookId,int flag) {          //  flag用于标记是借书还是还书，1表示借书，0表示还书
        SetBookStatus setBookStatus = new SetBookStatus();
        setBookStatus.setBookIdId(bookId);
        if(flag == 1) {             //借书
            setBookStatus.setStatus(1);                 //设置为占用
            int sign = borrowDAO.setBookStatus(setBookStatus);          //设置书籍状态
            if(sign > 0) {
                return 1;
            }
        }else {                     //还书
            setBookStatus.setStatus(0);
            int sign = borrowDAO.setBookStatus(setBookStatus);          //设置书籍状态
            if(sign > 0) {
                return 1;
            }
        }
        return 0;
    }

    //插入借阅书籍的记录
    public int insertBorrow(BorrowDAO borrowDAO,String userId,String bookId,String term) {
        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBookId(bookId);
        //获取系统当前时间
        String nowTime = this.getNowTime();
        borrow.setBorrowTime(nowTime);
        borrow.setTerm(term);
        borrow.setStatus(0);
        int result = borrowDAO.insertBorrow(borrow);        //插入借阅记录
        return result;
    }

    //设置还书时间
    public int setReturnBookTime(BorrowDAO borrowDAO,String userId,String bookId) {
        //在借阅记录表中设置最后一条记录的还书时间为当前时间。
        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBookId(bookId);
        String nowTime = this.getNowTime();
        borrow.setReturnTime(nowTime);
        borrow.setStatus(1);            //设置借阅书籍状态为已还书

        int result = borrowDAO.recordReturnBookTime(borrow);
        if(result > 0) {
            return 1;               //记录还书时间成功
        }
        return 0;                   //记录还书时间失败
    }

}