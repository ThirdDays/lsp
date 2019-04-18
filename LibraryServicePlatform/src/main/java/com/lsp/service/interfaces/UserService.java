package com.lsp.service.interfaces;

import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;

public interface UserService {
    public boolean addUser(String userId,String userName);
    public boolean deleteUser(String userId);
    public boolean modifyUser(Entity<User> entity);
}
