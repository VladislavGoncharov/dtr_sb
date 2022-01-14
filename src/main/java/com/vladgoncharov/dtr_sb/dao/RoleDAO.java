package com.vladgoncharov.dtr_sb.dao;

import java.util.List;

public interface RoleDAO {

    List<String> getRoleName(Long userId);
    List<String> getAllRole();

}
