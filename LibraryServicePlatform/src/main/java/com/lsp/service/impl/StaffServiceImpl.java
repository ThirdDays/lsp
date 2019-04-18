package com.lsp.service.impl;

import com.lsp.dao.StaffDAO;
import com.lsp.domain.po.Sign;
import com.lsp.domain.po.Staff;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;
import com.lsp.service.interfaces.StaffService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;


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
    public boolean login(String staffId, String passwords) {  //登录验证
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        String passwords2=staffDAO.findPasswords(staffId);
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

    //职工签到
    @Override
    public String sign(String staffId) {
        /*
            实现步骤：
            1.根据职工账号判断职工是否存在，存在返回true，否则返回false.
                1.如果返回true，记录此时签到的时间到数据库表中。
                2.如果返回false就表示职工不存在，签到无效
        */
        boolean bool = this.isStaffExist(staffId);      //判断职工是否存在
        if(bool) {
            String time = this.recordSignTime(staffId);      //记录职工此时签到的时间
            if(time != null) {         //记录签到时间成功
                return time;        //返回签到时间
            }
            return null;
        }
        return "职工不存在！";
    }

    //判断职工是否存在
    public boolean isStaffExist(String staffId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);
        Staff staff = staffDAO.findStaffById(staffId);
        if(staff != null) {
            return true;
        }
        return false;
    }
    //记录签到时间
    public String recordSignTime(String staffId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StaffDAO staffDAO=sqlSession.getMapper(StaffDAO.class);

        Sign sign = new Sign();
        sign.setStaffId(staffId);

        //获取系统当前时间
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        String nowTime = dateFormat.format(date);

        sign.setSignTime(nowTime);
//        System.out.println(nowTime);

        int result = staffDAO.insertSignTime(sign);
        if(result > 0) {
            return nowTime;
        }
        return null;
    }
}
