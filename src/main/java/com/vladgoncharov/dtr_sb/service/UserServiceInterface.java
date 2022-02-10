package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserServiceInterface extends UserDetailsService{

    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    Object findUserByAccount(String userName);

    UserRole findUserById(long id);

    void saveUser(AppUser user,String roleName);

    List<UserRole> getAllUsers(String roleName);

    void deleteUser(long id);

    void blockUser(long id);

    long getNumberOfUser(String roleName);

    void updateInfo(AppUserInfo userInfo);

    int getUserImg(String username);
}
