package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppRole;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
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
    public List<UserRole> getAllUsers(String roleName) {
        Session session = entityManager.unwrap(Session.class);

        String sql = "from UserRole where appRole.roleName='ROLE_"+ roleName +"'";
        List<UserRole> allUsers = session.createQuery(sql, UserRole.class).getResultList();

        return allUsers;
    }

    // select e from vlade where
    @Override
    public Object findUserAccount(String userName) {

        try{
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName",userName);

            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public UserRole findUserById(long id) {
        Session session = entityManager.unwrap(Session.class);
        long i = id-20; // delete after refresh table UserRole
        String sql = "Select e from " + UserRole.class.getName() + " e " //
                + " Where e.id =" + i;

        return session.createQuery(sql, UserRole.class).getSingleResult();
    }

    @Override
    public void saveUser(AppUser user) {
        Session session = entityManager.unwrap(Session.class);
        System.out.println(user.isAccountNonLocked());
        if (user.isAccountNonLocked()){
            session.update(user);
        }
        else {
            List<AppRole> getAllRole = session.createQuery("from AppRole ",AppRole.class).getResultList();
            AppRole userRole = getAllRole.stream().filter(x->x.getRoleName().equals("ROLE_USER")).findFirst().get();

            user.setAccountNonLocked(true);
            user.setEncrytedPassword(new EncrytedPasswordUtils().encrytePassword(user.getEncrytedPassword()));
            user.setRole(userRole.getRoleName());
            user.setAppUserInfo(new AppUserInfo());

            session.save(user);
            session.save(new UserRole(user,userRole));
        }
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

    @Override
    public long getNumberOfUser(String roleName) {
        return getAllUsers(roleName).size();
    }

    @Override
    public void updateInfo(AppUserInfo userInfo) {
        Session session = entityManager.unwrap(Session.class);
        session.update(userInfo);
    }
}
