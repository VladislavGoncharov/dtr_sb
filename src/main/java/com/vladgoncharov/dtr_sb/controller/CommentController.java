package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.entity.Comment;
import com.vladgoncharov.dtr_sb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Locale;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("addNewComment")
    public String addNewComment(@ModelAttribute("comment") Comment comment
            , Principal principal, Authentication authentication) {

        String role = authentication.getAuthorities().toString().toLowerCase(Locale.ROOT);
        commentService.addNewComment(comment, principal.getName(), role);

        return "redirect:/";
    }

    @RequestMapping("deleteComment_{commentId}")
    public String deleteComment(@PathVariable("commentId") long id) {
        commentService.deleteComment(id);
        return "redirect:/";
    }
}
