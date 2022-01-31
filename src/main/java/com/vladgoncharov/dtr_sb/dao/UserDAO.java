package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.entity.UserRole;

import java.util.List;

public interface UserDAO {

    List<UserRole> getAllUsers(String roleName);

    Object findUserAccount(String userName);

    UserRole findUserById(long id);

    void saveUser(AppUser user);

    void deleteUser(long id);

    void saveModerator(AppUser user);

    void blockUser(long id);

    long getNumberOfUser(String roleName);

    void updateInfo(AppUserInfo userInfo);
}
