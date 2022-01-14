package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppUser;

import java.util.List;

public interface UserDAO {

    List<AppUser> showAllUsers();

    AppUser findUserAccount(String userName);

    void saveUser(AppUser user);
}
