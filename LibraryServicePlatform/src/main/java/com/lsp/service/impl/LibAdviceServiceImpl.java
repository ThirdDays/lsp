package com.lsp.service.impl;

import com.lsp.dao.LibAdviceDAO;
import com.lsp.domain.po.LibAdvice;
import com.lsp.service.interfaces.LibAdviceService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LibAdviceServiceImpl implements LibAdviceService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public boolean addLibAdvice(String content) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        LibAdviceDAO libAdviceDAO=sqlSession.getMapper(LibAdviceDAO.class);
        LibAdvice libAdvice = new LibAdvice();
        libAdvice.setContent(content);
        libAdvice.setTime(this.getNowTime());
        int result = libAdviceDAO.addLibAdvice(libAdvice);
        if(result > 0) {
            return true;
        }
        return false;
    }
    //获取系统当前时间
    public String getNowTime() {
        //获取系统当前时间
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        String nowTime = dateFormat.format(date);
        return nowTime;
    }
    @Override
    public List<LibAdvice> queryLibAdvice() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        LibAdviceDAO libAdviceDAO=sqlSession.getMapper(LibAdviceDAO.class);
        List<LibAdvice> list = libAdviceDAO.queryLibAdvice();
        return list;
    }
}
