package com.vladgoncharov.dtr_sb.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "app_user", uniqueConstraints = { //
        @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name")})
public class AppUser implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @NotBlank(message = "не допустимые символы")
    @Size(min = 2, max = 36, message = "от 2 до 36 символов")
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Size(min = 2, message = "от 2 символов")
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Transient
    private String encrytedPasswordCheck;


    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean accountNonLocked;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_info")
    private AppUserInfo appUserInfo;

    @Transient
    private String role;

    public AppUser() {
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return encrytedPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEncrytedPasswordCheck() {
        return encrytedPasswordCheck;
    }

    public void setEncrytedPasswordCheck(String encrytedPasswordCheck) {
        this.encrytedPasswordCheck = encrytedPasswordCheck;
    }

    public AppUserInfo getAppUserInfo() {
        return appUserInfo;
    }

    public void setAppUserInfo(AppUserInfo appUserInfo) {
        this.appUserInfo = appUserInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return accountNonLocked == appUser.accountNonLocked
                && Objects.equals(userId, appUser.userId)
                && Objects.equals(userName, appUser.userName)
                && Objects.equals(encrytedPassword, appUser.encrytedPassword)
                && Objects.equals(encrytedPasswordCheck, appUser.encrytedPasswordCheck)
                && Objects.equals(appUserInfo, appUser.appUserInfo)
                && Objects.equals(role, appUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId) * 31 * 7 * 33;
    }
}
