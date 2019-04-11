package com.lsp.service.impl;

import com.lsp.dao.CheckUserDAO;
import com.lsp.domain.Lib;
import com.lsp.service.interfaces.LibCheckService;
import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class LibCheckServiceImpl implements LibCheckService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public boolean checkUser(String id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CheckUserDAO checkUserDAO=sqlSession.getMapper(CheckUserDAO.class);

        String name=checkUserDAO.queryUserName(id);    //验证用户是否存在
        Timestamp lastEntryTime=checkUserDAO.queryLastEntryTime(id);     //获取上一次进馆时间
        System.out.println(lastEntryTime);
        if(lastEntryTime==null && name!=null) {
            Date nowTime=new Date();    //获取当前时间
            Lib lib=new Lib();
            lib.setId(id);
            lib.setName(name);
            lib.setEntryTime(new Timestamp(nowTime.getTime()));
            int result=checkUserDAO.insertEntryTime(lib);
            if(result>0) {
                return true;
            }
            return false;
        }

        Timestamp nowTime=new Timestamp(new Date().getTime());    //获取当前时间
        long c=nowTime.getTime()-lastEntryTime.getTime();
        System.out.println("nowTime:"+nowTime.getTime());
        System.out.println("lastEntryTime:"+lastEntryTime.getTime());
        System.out.println("c:"+c);
        if(c>3*1000*100*60&&name!=null){   //当前进馆与上一次进馆时间间隔要超过3分钟，即上一次进馆3分钟后才能再次进馆
            Lib lib=new Lib();
            lib.setId(id);
            lib.setName(name);
            lib.setEntryTime(new Timestamp(nowTime.getTime()));
            int result=checkUserDAO.insertEntryTime(lib);
            if(result>0) {
                return true;
            }
            return false;
        }
        return false;
    }
}
