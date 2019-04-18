package com.lsp.dao;

import com.lsp.domain.po.Sign;
import com.lsp.domain.po.Staff;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;

/*
    职工接口
 */
public interface StaffDAO{
    /*
        function:添加职工信息
        @param:职工信息的封装类
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int insertStaff(Staff staff);    //添加职工信息
    /*
        function:删除职工信息
        @param:职工id
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int deleteStaff(String staId);
    /*
        function:更新职工信息
        @param:职工更新信息的封装类
        @return 返回所影响的行数，0表示失败，正数表示成功
     */
    public int updateStaff(Entity<Staff> entity);


    /*
        function:根据职工id查询职工信息
        @param:职工id
        @return:返回职工信息的封装类对象
     */
    public Staff findStaffById(String staId);
    /*
        function:根据职工姓名查询职工信息
        @param:职工姓名
        @return:返回职工信息的封装类对象
     */
    public Staff findStaffByName(String name);

    public String findPasswords(String staId);  //查询密码

    public int modifyPasswords(ServiceToDAOVO serviceToDAOVO);  //修改密码

    public int insertSignTime(Sign sign);           //记录签到时间
}
