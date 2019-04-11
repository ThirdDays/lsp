package com.lsp.dao;

import com.lsp.domain.Lib;

import java.sql.Date;

public interface CheckUserDAO {

    public String queryUserName(String id);   //查询用户

    public java.sql.Timestamp queryLastEntryTime(String id);

    public int insertEntryTime(Lib lib);
}
