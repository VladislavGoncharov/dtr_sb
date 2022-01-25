package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    void addNewComment(Comment comment);

    void deleteComment(long id);

}
