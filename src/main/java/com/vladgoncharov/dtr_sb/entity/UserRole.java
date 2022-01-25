package com.vladgoncharov.dtr_sb.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY
            ,cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Id", nullable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Role_Id", nullable = false)
    private AppRole appRole;

    @Transient
    private Long userId;

    @Transient
    private String userName;

    @Transient
    private String roleName;

    @Transient
    private String encrytedPassword;

    @Transient
    private boolean accountNonLocked;

    public UserRole(AppUser appUser,AppRole appRole) {
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public Long getUserId() {
        return appUser.getUserId();
    }

    public String getUserName() {
        return appUser.getUserName();
    }

    public String getRoleName() {
        return appRole.getRoleName();
    }

    public String getEncrytedPassword() {
        return appUser.getEncrytedPassword();
    }

    public boolean isAccountNonLocked() {
        return appUser.isAccountNonLocked();
    }
}
