package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDAO {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    List<UserRole> getAllUsers(String roleName);

    Object findUserByAccount(String username);

    UserRole findUserById(long id);

    void saveUser(AppUser user,String roleName);

    void deleteUser(long id);

    void blockUser(long id);

    long getNumberOfUser(String roleName);

    void updateInfo(AppUserInfo userInfo);

    int getUserImg(String username);
}
