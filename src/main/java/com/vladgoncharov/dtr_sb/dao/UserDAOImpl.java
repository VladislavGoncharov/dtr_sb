package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.AppRole;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import com.vladgoncharov.dtr_sb.utility.EncrytedPasswordUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = (AppUser) findUserByAccount(username);
        if (user == null){
            throw new UsernameNotFoundException("User "+username+
                    " was not found in the database");
        }

        List<String> roleNames = roleDAO.getRoleName(user.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role: roleNames){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        return (UserDetails) new User(user.getUsername(), user.getEncrytedPassword()
                ,user.isEnabled(),user.isAccountNonExpired()
                ,user.isCredentialsNonExpired(),user.isAccountNonLocked(), grantList);
    }

    @Override
    public List<UserRole> getAllUsers(String roleName) {
        Session session = entityManager.unwrap(Session.class);

        String sql = "from UserRole where appRole.roleName='ROLE_"+ roleName +"'";

        return session.createQuery(sql, UserRole.class).getResultList();
    }

    @Override
    public Object findUserByAccount(String username) {

        try{
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.username = :username ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("username", username);

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
    public void saveUser(AppUser user, String roleName) {
        Session session = entityManager.unwrap(Session.class);

        if (user.isAccountNonLocked()){
            session.update(user);
        }
        else {
            List<AppRole> getAllRole = session.createQuery("from AppRole ",AppRole.class).getResultList();
            AppRole userRole = getAllRole.stream().filter(x->x.getRoleName().equals(roleName)).findFirst().get();

            user.setAccountNonLocked(true);
            user.setEncrytedPassword(new EncrytedPasswordUtils().encrytePassword(user.getEncrytedPassword()));
            user.setRole(userRole.getRoleName());
            user.setAppUserInfo(new AppUserInfo());

            session.save(user);
            session.save(new UserRole(user,userRole));
        }
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

    @Override
    public int getUserImg(String username) {
        AppUser user = (AppUser) findUserByAccount(username);
        return user.getAppUserInfo().getImg();
    }
}
