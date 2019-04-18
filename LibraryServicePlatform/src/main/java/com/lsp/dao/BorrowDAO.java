package com.lsp.dao;


import com.lsp.domain.po.Borrow;
import com.lsp.domain.vo.SetBookStatus;

import java.sql.Timestamp;
import java.util.List;

public interface BorrowDAO {
    /*
     @return:如果返回值为空则表示借阅人之前没有借过，反之借过！
  */
    public String queryIdentifier(String identifier);       //查询借阅人

    public String findBookId(String bookId);        //查找书籍号

    public int getBookStatus(String bookId);           //查询书籍的借阅状态

    public int setBookStatus(SetBookStatus setBookStatus);        //更新（设置）指定书籍的状态

    public int insertBorrow(Borrow borrow);         //插入借阅记录

    public int recordReturnBookTime(Borrow borrow);                     //记录还书时间

    public List<Borrow> getBookNotBeReturnedBorrow(String userId);           //获取借阅人未还书的记录

    public List<Borrow> queryBorrowNotBeReturnedButOverdueRecord();             //查询所有借阅记录

    public List<Borrow> queryUserBorrowRecord(String userId);       //查询指定用户的借阅记录
}
