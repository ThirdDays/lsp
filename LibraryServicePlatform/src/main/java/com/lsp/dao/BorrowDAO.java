package com.lsp.dao;

import com.lsp.domain.LoadBook;
import com.lsp.domain.vo.SetBookStatus;

import java.sql.Timestamp;

public interface BorrowDAO {
    /*
     @return:如果返回值为空则表示借阅人之前没有借过，反之借过！
  */
    public String queryIdentifier(String identifier);       //查询借阅人

    public String findBookId(String bookId);        //查找书籍号

    public int findStatus(String bookId);           //查询书籍的借阅状态

    public LoadBook queryLastRecord(String identifier);       //查找借阅人最后一次借阅记录

    public int setBookStatus(SetBookStatus setBookStatus);        //更新（设置）指定书籍的状态

    public int insertBorrow(LoadBook loadBook);         //插入借阅记录

    public int updateBorrow(LoadBook loadBook);      //更新借阅记录，即还书
}
