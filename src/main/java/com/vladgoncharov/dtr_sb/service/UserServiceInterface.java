package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserServiceInterface extends UserDetailsService {

    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    AppUser findUserAccount(String userName);

    void saveUser(AppUser user);

}
