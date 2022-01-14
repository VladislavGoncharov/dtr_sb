package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppRole;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import com.vladgoncharov.dtr_sb.utility.EncrytedPasswordUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Stream;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<AppUser> showAllUsers() {

        Session session = entityManager.unwrap(Session.class);
        List<AppUser> allUsers = session.createQuery("from AppUser", AppUser.class).getResultList();

        return allUsers;
    }

    // select e from vlade where
    @Override
    public AppUser findUserAccount(String userName) {

        try{
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName",userName);

            return (AppUser)query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

    }

    @Override
    public void saveUser(AppUser user) {
        Session session = entityManager.unwrap(Session.class);

        user.setEnabled(true);
        user.setEncrytedPassword(new EncrytedPasswordUtils().encrytePassword(user.getEncrytedPassword()));

        session.save(user);

        List<AppRole> getAllRole = session.createQuery("from AppRole ",AppRole.class).getResultList();
        AppRole userRole = getAllRole.stream().filter(x->x.getRoleName().equals("ROLE_USER")).findFirst().get();

        session.save(new UserRole(user,userRole));
    }
}
