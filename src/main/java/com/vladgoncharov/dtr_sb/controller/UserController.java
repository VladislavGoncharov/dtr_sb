package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.service.UserServiceInterface;
import com.vladgoncharov.dtr_sb.utility.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserServiceInterface userDetailsService;

    @GetMapping("/registration")
    public String registrationUser(Model model) {
        model.addAttribute("user", new AppUser());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user
            , BindingResult bindingResult,Model model) {

        AppUser appUser = userDetailsService.findUserAccount(user.getUserName());

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (appUser != null) {
            model.addAttribute("exceptionUserName"," такой пользователь уже существует");
            return "registration";
        }
        if (!user.getEncrytedPassword().equals(user.getEncrytedPasswordCheck())) {
            model.addAttribute("exceptionPasswordCheck"," пароли не совпадают");
            return "registration";
        }
        userDetailsService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

//    @RequestMapping(value="/logout", method = RequestMethod.POST)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout=true";
//    }

    @GetMapping("/userInfo")
    public String userInfo(Model model, Principal principal) {
        // After user login successfully.
        String userName = principal.getName();
        model.addAttribute("userName111", userName);

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfo";
    }

    @GetMapping( "/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403";
    }
}
