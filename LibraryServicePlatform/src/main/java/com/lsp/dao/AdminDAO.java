package com.lsp.dao;

import com.lsp.domain.po.Admin;
import com.lsp.domain.complex.Entity;
import com.lsp.domain.vo.ServiceToDAOVO;

/*
    管理员接口
 */
public interface AdminDAO{
    /*
        function:添加管理员信息
        @param:管理员信息封装类
        @return 返回所影响的行数，0表示插入失败，正数表示插入成功
     */
    public int insertAdmin(Admin admin);    //添加管理员信息
    /*
        function:删除管理员信息
        @param：管理员信息id
        @return 返回所影响的行数，0表示插入失败，正数表示插入成功
     */
    public int deleteAdminById(String id);
    /*
        function:更新管理员信息
        @param:管理员更新信息的id
        @return 返回所影响的行数，0表示插入失败，正数表示插入成功
     */
    public int updateAdmin(Entity<Admin> entity);
    /*
        function:通过id查询管理员信息
        @param:管理员id
        @return:返回管理员信息的封装类
     */
    public Admin findAdminById(String id);
    /*
        function:通过管理员姓名查询管理员信息
        @param:管理员姓名
        @return:返回管理员信息的封装类
     */
    public Admin findAdminByName(String name);

    public String findPasswords(String adminId);    //查询密码

    public int modifyPasswords(ServiceToDAOVO serviceToDAOVO);   //修改密码

}