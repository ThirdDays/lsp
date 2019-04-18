package com.lsp.service.impl;

import com.lsp.dao.AdminDAO;
import com.lsp.domain.po.Admin;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;
import com.lsp.service.interfaces.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

//    private SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)this.getApplicationContext().getBean("sqlSessionFactory");
//    private SqlSession sqlSession=sqlSessionFactory.openSession();
//    AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
//    private SqlSessionFactory sqlSessionFactory;
//    private SqlSession sqlSession;
//    private AdminDAO adminDAO;
//    public AdminServiceImpl() {
//        sqlSessionFactory=(SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
//        sqlSession=sqlSessionFactory.openSession();
//        adminDAO=sqlSession.getMapper(AdminDAO.class);
//    }
//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
//    private AdminDAO adminDAO;
//    public AdminServiceImpl() {
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        adminDAO=sqlSession.getMapper(AdminDAO.class);
//    }
    @Override
    public int insertAdmin(Admin admin) {
//        SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)this.getApplicationContext().getBean("sqlSessionFactory");
//        SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)applicationContext.getBean("sqlSessionFactory") ;
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        int result=adminDAO.insertAdmin(admin);
//        sqlSession.close();
        return result;
    }

    @Override
    public int deleteAdminById(String id) {
//        SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)this.getApplicationContext().getBean("sqlSessionFactory");
//        SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)applicationContext.getBean("sqlSessionFactory") ;
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        int result=adminDAO.deleteAdminById(id);
        return result;
    }

    @Override
    public int updateAdmin(Entity<Admin> entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        int result=adminDAO.updateAdmin(entity);
        return result;
    }

    @Override
    public Admin findAdminById(String adminId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        Admin admin=adminDAO.findAdminById(adminId);
        return admin;
    }

    @Override
    public Admin findAdminByName(String name) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        Admin admin=adminDAO.findAdminByName(name);
        return admin;
    }

    @Override
    public boolean login(String adminId, String passwords) {    //登录
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        String passwords2=adminDAO.findPasswords(adminId);
        if(passwords.equals(passwords2)) {  //密码匹配
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyPasswords(String adminId, String newPasswords) {   //修改密码
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminDAO adminDAO=sqlSession.getMapper(AdminDAO.class);
        ServiceToDAOVO serviceToDAOVO=new ServiceToDAOVO();
        serviceToDAOVO.setId(adminId);
        serviceToDAOVO.setPasswords(newPasswords);
        int result=adminDAO.modifyPasswords(serviceToDAOVO);        //更新密码操作
        if(result>0) {
            return true;
        }
        return false;
    }
}
