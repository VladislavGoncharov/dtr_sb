package com.vladgoncharov.dtr_sb.dao;

import com.vladgoncharov.dtr_sb.entity.Comment;
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

    @Override
    public List<Comment> getAllComments() {
        Session session = entityManager.unwrap(Session.class);

        List<Comment> getAllComments =
                session.createQuery("from Comment",Comment.class).getResultList();
        Collections.reverse(getAllComments);

        return getAllComments;
    }

    @Override
    public void deleteComment(long id) {
        Session session = entityManager.unwrap(Session.class);

        Query deleteComment = session.createQuery("delete from Comment where id=:commentId");
        deleteComment.setParameter("commentId",id).executeUpdate();
    }

    @Override
    public void addNewComment(Comment comment) {
        Session session = entityManager.unwrap(Session.class);

        comment.setTime(String.valueOf(LocalDateTime.now()));

        session.save(comment);
    }
}
