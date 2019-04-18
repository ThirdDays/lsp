package com.lsp.dao;

import com.lsp.domain.complex.Entity;
import com.lsp.domain.po.User;

public interface UserDAO {
    public int addUser(User user);
    public int deleteUser(String userId);
    public int modifyUser(Entity<User> entity);
}
