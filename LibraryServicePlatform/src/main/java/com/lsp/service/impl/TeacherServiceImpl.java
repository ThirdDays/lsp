package com.lsp.service.impl;

import com.lsp.dao.TeacherDAO;
import com.lsp.domain.po.Teacher;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;
import com.lsp.service.interfaces.TeacherService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int insertTeacher(Teacher teacher) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);
        int result=teacherDAO.insertTeacher(teacher);
        return result;
    }

    @Override
    public int deleteTeacher(String tId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);       //代理方式实现dao接口
        int result=teacherDAO.deleteTeacher(tId);
        return result;
    }

    @Override
    public int updateTeacher(Entity<Teacher> entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);       //代理方式实现dao接口
        int result=teacherDAO.updateTeacher(entity);
        return result;
    }

    @Override
    public Teacher findTeacherById(String tId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);
        Teacher teacher=teacherDAO.findTeacherById(tId);
        return teacher;
    }

    @Override
    public Teacher findTeacherByName(String tName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);
        Teacher teacher=teacherDAO.findTeacherByName(tName);
        return teacher;
    }

    @Override
    public boolean login(String tId, String passwords) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);
        String passwords2=teacherDAO.findPasswords(tId);
        if(passwords.equals(passwords2)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyPasswords(String tId, String newPasswords) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TeacherDAO teacherDAO=sqlSession.getMapper(TeacherDAO.class);
        ServiceToDAOVO serviceToDAOVO=new ServiceToDAOVO();
        serviceToDAOVO.setId(tId);
        serviceToDAOVO.setPasswords(newPasswords);
        int result=teacherDAO.modifyPasswords(serviceToDAOVO);
        if(result>0) {
            return true;
        }
        return false;
    }
}
