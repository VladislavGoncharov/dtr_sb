package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.UserRole;

import java.util.List;

public interface UserDAO {

    List<UserRole> getAllUsers();

    AppUser findUserAccount(String userName);

    void saveUser(AppUser user);

    void deleteUser(long id);

    void saveModerator(AppUser user);

    void blockUser(long id);
}
