package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserServiceInterface extends UserDetailsService {

    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    AppUser findUserAccount(String userName);

    void saveUser(AppUser user);

    List<UserRole> getAllUsers();

    void deleteUser(long id);

    void saveModerator(AppUser user);

    void blockUser(long id);

}
