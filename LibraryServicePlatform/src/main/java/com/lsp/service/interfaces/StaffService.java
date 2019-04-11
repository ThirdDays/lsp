package com.lsp.service.interfaces;

import com.lsp.domain.Staff;
import com.lsp.domain.complex.Entity;

public interface StaffService {

    public int insertStaff(Staff staff);
    public int deleteStaff(String staId);
    public int updateStaff(Entity<Staff> entity);

    public Staff findStaffById(String staId);
    public Staff findStaffByName(String staName);

    public boolean login(String staId,String passwords);        //职工登录
    public boolean modifyPasswords(String staId,String newPasswords);   //修改密码

}
