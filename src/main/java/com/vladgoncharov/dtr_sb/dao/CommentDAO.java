package com.vladgoncharov.dtr_sb.dao;


import com.vladgoncharov.dtr_sb.entity.Comment;

import java.util.List;

public interface CommentDAO {


    List<Comment> getAllComments();

    void deleteComment(long id);

    void addNewComment(Comment comment);
}
