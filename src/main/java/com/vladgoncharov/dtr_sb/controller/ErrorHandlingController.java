package com.vladgoncharov.dtr_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
