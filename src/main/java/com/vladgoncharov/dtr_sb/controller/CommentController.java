package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.dao.RoleDAO;
import com.vladgoncharov.dtr_sb.dao.UserDAO;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.Comment;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import com.vladgoncharov.dtr_sb.service.CommentService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class CommentController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private CommentService commentService;

    @PostMapping("addNewComment")
    public String addNewComment(@ModelAttribute("comment") Comment comment, Principal principal
            , Authentication authentication) {

        comment.setUsername(principal.getName());
        comment.setRole(authentication.getName());
        commentService.addNewComment(comment);

        return "redirect:/";
    }

    @PostMapping("deleteComment")
    public String deleteComment(@RequestParam("commentId")long id){
        commentService.deleteComment(id);
        return "redirect:/";
    }

    @PostMapping("showComment")
    public String showComment(@RequestParam("showCommentPlus") int scp, Model model){
        System.out.println("ok");
        model.addAttribute("showComment",scp);
        return "redirect:/";
    }
}
