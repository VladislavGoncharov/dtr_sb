package com.vladgoncharov.dtr_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorHandlingController {

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/423")
    public String accountIsLocked() {
        return "423";
    }

    @PostMapping("changeTheDateException")
    public String changeTheDateException() {
        return "change-the-date-exception";
    }
}
