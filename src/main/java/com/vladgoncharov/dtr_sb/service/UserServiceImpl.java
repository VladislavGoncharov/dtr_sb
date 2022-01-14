package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.dao.RoleDAO;
import com.vladgoncharov.dtr_sb.dao.UserDAO;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser user = this.userDAO.findUserAccount(userName);
        if (user == null){
            System.out.println("User not found! "+userName);
            throw new UsernameNotFoundException("User "+userName+
                    " was not found in the database");
        }

        System.out.println("Found User: "+user);

        List<String> roleNames = this.roleDAO.getRoleName(user.getUserId());

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
    public AppUser findUserAccount(String userName) {
        return userDAO.findUserAccount(userName);
    }

    public void saveUser(AppUser user){

        userDAO.saveUser(user);

    }


}
