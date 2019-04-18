package com.lsp.service.impl;

import com.lsp.dao.AdminDAO;
import com.lsp.dao.UserDAO;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;
import com.lsp.service.interfaces.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public boolean addUser(String userId, String userName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        int result = userDAO.addUser(user);
        if(result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
        int result = userDAO.deleteUser(userId);
        if(result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyUser(Entity<User> entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
        int result = userDAO.modifyUser(entity);
        if(result > 0) {
            return true;
        }
        return false;
    }
}
