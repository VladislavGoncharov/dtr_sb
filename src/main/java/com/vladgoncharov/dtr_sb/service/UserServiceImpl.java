package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.dao.RoleDAO;
import com.vladgoncharov.dtr_sb.dao.UserDAO;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser user = (AppUser) userDAO.findUserAccount(userName);
        if (user == null){
            System.out.println("User not found! "+userName);
            throw new UsernameNotFoundException("User "+userName+
                    " was not found in the database");
        }

        System.out.println("Found User: "+user);

        List<String> roleNames = roleDAO.getRoleName(user.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role: roleNames){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(user.getUserName(),
                user.getEncrytedPassword(), grantList);

        return userDetails;
    }

    @Override
    public Object findUserAccount(String userName) {
        return userDAO.findUserAccount(userName);
    }

    @Override
    public UserRole findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public void saveUser(AppUser user){
        userDAO.saveUser(user);
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
    public void saveModerator(AppUser user) {
        userDAO.saveModerator(user);
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

}
