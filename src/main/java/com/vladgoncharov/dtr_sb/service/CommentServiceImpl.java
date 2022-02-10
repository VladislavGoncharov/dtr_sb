package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.dao.CommentDAO;
import com.vladgoncharov.dtr_sb.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> getAllComments() {
        return commentDAO.getAllComments();
    }

    @Override
    public void addNewComment(Comment comment,String username,String role) {
        commentDAO.addNewComment(comment,username,role);
    }

    @Override
    public void deleteComment(long id) {
        commentDAO.deleteComment(id);
    }


}
