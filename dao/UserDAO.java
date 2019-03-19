package com.ecomm.dao;

import com.ecomm.Model.UserDetail;

public interface UserDAO {
public boolean registerUser(UserDetail user);
public UserDetail getuser(String username);
public boolean updateuser(UserDetail userdetail);

}
