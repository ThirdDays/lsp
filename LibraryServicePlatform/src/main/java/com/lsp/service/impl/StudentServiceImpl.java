package com.lsp.service.impl;

import com.lsp.dao.StudentDAO;
import com.lsp.domain.Student;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;
import com.lsp.service.interfaces.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        int result=studentDAO.insertStudent(student);
        return result;
    }

    @Override
    public int deleteStudent(String stuId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        int result=studentDAO.deleteStudent(stuId);
        return result;
    }

    @Override
    public int updateStudent(Entity<Student> entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        int result=studentDAO.updateStudent(entity);
        return result;
    }

    @Override
    public Student findStudentById(String stuId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        Student student=studentDAO.findStudentById(stuId);
        return student;
    }

    @Override
    public Student findStudentByName(String stuName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        Student student=studentDAO.findStudentByName(stuName);
        return student;
    }

    @Override
    public boolean login(String stuId, String passwords) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        String passwords2=studentDAO.findPasswords(stuId);
        if(passwords.equals(passwords2)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyPasswords(String stuId, String newPasswords) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        ServiceToDAOVO serviceToDAOVO=new ServiceToDAOVO();
        serviceToDAOVO.setId(stuId);
        serviceToDAOVO.setPasswords(newPasswords);
        int result=studentDAO.modifyPasswords(serviceToDAOVO);
        if(result>0) {
            return true;
        }
        return false;
    }
}
