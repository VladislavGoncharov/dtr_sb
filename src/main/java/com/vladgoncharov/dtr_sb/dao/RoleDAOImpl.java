package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<String> getRoleName(Long userId) {

        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
                + " where ur.appUser.userId = :userId ";

        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);

        return query.getResultList();
    }
}
