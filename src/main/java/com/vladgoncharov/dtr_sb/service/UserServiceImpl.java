package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.dao.UserDAO;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return userDAO.loadUserByUsername(userName);
    }

    @Override
    public Object findUserByAccount(String userName) {
        return userDAO.findUserByAccount(userName);
    }

    @Override
    public UserRole findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public void saveUser(AppUser user,String roleName){
        userDAO.saveUser(user,roleName);
    }

    @Override
    public List<UserRole> getAllUsers(String roleName) {
        return userDAO.getAllUsers(roleName);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public void blockUser(long id) {
        userDAO.blockUser(id);
    }

    @Override
    public long getNumberOfUser(String roleName) {
        return userDAO.getNumberOfUser(roleName);
    }

    @Override
    public void updateInfo(AppUserInfo userInfo) {
        userDAO.updateInfo(userInfo);
    }

    @Override
    public int getUserImg(String username) {
        return userDAO.getUserImg(username);
    }

}
