package com.lsp.service.impl;

import com.lsp.dao.StaffDAO;
import com.lsp.domain.Staff;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;
import com.lsp.service.interfaces.StaffService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements com.lsp.service.interfaces.StaffService {

//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int insertStaff(Staff staff) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        int result=staffDAO.insertStaff(staff);
        return result;
    }

    @Override
    public int deleteStaff(String staId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        int result=staffDAO.deleteStaff(staId);
        return result;
    }

    @Override
    public int updateStaff(Entity<Staff> entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        int result=staffDAO.updateStaff(entity);
        return result;
    }

    @Override
    public Staff findStaffById(String staId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        Staff staff=staffDAO.findStaffById(staId);
        return staff;
    }

    @Override
    public Staff findStaffByName(String staName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        Staff staff=staffDAO.findStaffByName(staName);
        return staff;
    }

    @Override
    public boolean login(String staId, String passwords) {  //登录验证
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        String passwords2=staffDAO.findPasswords(staId);
        if(passwords.equals(passwords2)) {      //匹配成功
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyPasswords(String staId, String newPasswords) { //修改密码
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        ServiceToDAOVO serviceToDAOVO=new ServiceToDAOVO();
        serviceToDAOVO.setId(staId);
        serviceToDAOVO.setPasswords(newPasswords);
        int result=staffDAO.modifyPasswords(serviceToDAOVO);
        if(result>0) {
            return true;
        }
        return false;
    }
}
