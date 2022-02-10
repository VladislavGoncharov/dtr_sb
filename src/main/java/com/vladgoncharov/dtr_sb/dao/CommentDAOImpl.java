package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.Comment;
import com.vladgoncharov.dtr_sb.service.UserServiceInterface;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Override
    public List<Comment> getAllComments() {
        Session session = entityManager.unwrap(Session.class);

        List<Comment> getAllComments = session.createQuery("from Comment",Comment.class).getResultList();
        Collections.reverse(getAllComments); //перевернул чтобы последние комменты были вверху

        return getAllComments;
    }

    @Override
    public void deleteComment(long id) {
        Session session = entityManager.unwrap(Session.class);

        Query deleteComment = session.createQuery("delete from Comment where id=:commentId");
        deleteComment.setParameter("commentId",id).executeUpdate();
    }

    @Override
    public void addNewComment(Comment comment,String username,String role) {
        Session session = entityManager.unwrap(Session.class);

        comment.setUsername(username);
        comment.setRole(role.substring(6,role.length()-1));
        comment.setTime(String.valueOf(LocalDateTime.now()));
        comment.setImg(userServiceInterface.getUserImg(username));

        session.save(comment);
    }
}
