package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppRole;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import com.vladgoncharov.dtr_sb.utility.EncrytedPasswordUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<UserRole> getAllUsers() {

        Session session = entityManager.unwrap(Session.class);

        List<UserRole> allUsers = session.createQuery("from UserRole", UserRole.class).getResultList();

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

        List<AppRole> getAllRole = session.createQuery("from AppRole ",AppRole.class).getResultList();
        AppRole userRole = getAllRole.stream().filter(x->x.getRoleName().equals("ROLE_USER")).findFirst().get();

        user.setAccountNonLocked(true);
        user.setEncrytedPassword(new EncrytedPasswordUtils().encrytePassword(user.getEncrytedPassword()));
        user.setRole(userRole.getRoleName());

        session.save(user);
        session.save(new UserRole(user,userRole));
    }

    @Override
    public void saveModerator(AppUser user) {
        Session session = entityManager.unwrap(Session.class);

        List<AppRole> getAllRole = session.createQuery("from AppRole ",AppRole.class).getResultList();
        AppRole userRole = getAllRole.stream().filter(x->x.getRoleName().equals("ROLE_MODERATOR")).findFirst().get();

        user.setAccountNonLocked(true);
        user.setEncrytedPassword(new EncrytedPasswordUtils().encrytePassword(user.getEncrytedPassword()));
        user.setRole(userRole.getRoleName());

        session.save(user);
        session.save(new UserRole(user,userRole));
    }

    @Override
    public void deleteUser(long id) {
        Session session = entityManager.unwrap(Session.class);

        Query queryUserRole = session.createQuery("delete from UserRole where appUser.userId=:userId");
        queryUserRole.setParameter("userId",id).executeUpdate();

        Query queryAppUser = session.createQuery("delete from AppUser where userId=:userId");
        queryAppUser.setParameter("userId",id).executeUpdate();
    }

    @Override
    public void blockUser(long id) {
        Session session = entityManager.unwrap(Session.class);

        AppUser user = session.get(AppUser.class,id);

        user.setAccountNonLocked(!user.isAccountNonLocked());
    }
}
