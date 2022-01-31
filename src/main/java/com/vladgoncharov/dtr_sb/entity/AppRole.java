package com.vladgoncharov.dtr_sb.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_role",
uniqueConstraints = {
        @UniqueConstraint(name = "APP_ROLE_UK",columnNames = "Role_Name")
})
public class AppRole implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column(name = "Role_Id",nullable = false)
    private Long roleId;

    @Column(name = "Role_Name",length = 30,nullable = false)
    private String roleName;

    public AppRole() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRole role = (AppRole) o;
        return Objects.equals(roleId, role.roleId) && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }
}
