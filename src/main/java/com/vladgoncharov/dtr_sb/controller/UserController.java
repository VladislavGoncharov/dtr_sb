package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.service.EmailSenderService;
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
    private UserServiceInterface userServiceInterface;

    @Autowired
    EmailSenderService emailSenderService;


    @GetMapping("/registration")
    public String registrationUser(Model model) {
        model.addAttribute("user", new AppUser());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user
            , Model model, BindingResult bindingResult) {

        AppUser appUser = (AppUser) userServiceInterface.findUserAccount(user.getUserName());


        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (appUser != null) {
            model.addAttribute("exceptionUserName", " такой пользователь уже существует");
            return "registration";
        }
        if (!user.getEncrytedPassword().equals(user.getEncrytedPasswordCheck())) {
            model.addAttribute("exceptionPasswordCheck", " пароли не совпадают");
            return "registration";
        }
        userServiceInterface.saveUser(user);
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

    @GetMapping("/userInfo_{currentUsername}")
    public String userInfo(@PathVariable("currentUsername") String currentUsername, Model model) {

        AppUser user = (AppUser) userServiceInterface.findUserAccount(currentUsername);
        model.addAttribute("userInfo", user.getAppUserInfo());
        model.addAttribute("username", currentUsername);

        return "user_info";
    }

    @PostMapping("/userInfo_{currentUsername}")
    public String userInfoSave(@PathVariable("currentUsername") String currentUsername,
                               @Valid @ModelAttribute("userInfo") AppUserInfo userInfo,
                               BindingResult bindingResult,
                               Model model) {

        if (bindingResult.hasErrors()) {
            return "user_info_update";
        }
        userServiceInterface.updateInfo(userInfo);

        model.addAttribute("userName", currentUsername);
        model.addAttribute("userInfo", userInfo);

        return "user_info";
    }

    @GetMapping("/updateUserInfo")
    public String userInfoUpdate(Model model, Principal principal) {

        String userName = principal.getName();
        model.addAttribute("currentUsername", userName);

        AppUser user = (AppUser) userServiceInterface.findUserAccount(userName);
        model.addAttribute("userInfo", user.getAppUserInfo());

        return "user_info_update";
    }
//
//    @GetMapping("/userInfo")
//    public String userInfo(Model model, Principal principal) {
//        // After user login successfully.
//        String userName = principal.getName();
//        model.addAttribute("userName111", userName);
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "userInfo";
//    }

    @GetMapping("/403")
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

    @GetMapping("/checkingEmail_{currentUsername}")
    public String checkingEmail(@PathVariable String currentUsername,Model model) {


        AppUser user = (AppUser) userServiceInterface.findUserAccount(currentUsername);
        try{
            emailSenderService.sendEmail(
                    "datetimeresult@gmail.com",
                    user.getAppUserInfo().getEmail(),
                    "Подтвердить email на сайте DateTimeResult.ru",
                    "Здравствуйте " + currentUsername + ". \nЧтобы подтвердить свою почту нужно перейти по этой ссылке->" +
                            "http://localhost:8080/confirmYourEmailAddress_"
                            + currentUsername);
        }catch (Exception e){
            System.out.println(e);
            model.addAttribute("isSuccessful",false);
            return "email_response";
        }


        return "redirect:/";
    }

    @GetMapping("/confirmYourEmailAddress_{currentUsername}")
    public String confirmYourEmailAddress(@PathVariable String currentUsername,Model model) {

        emailSenderService.confirmYourEmailAddress(currentUsername);
        model.addAttribute("isSuccessful",true);

        return "email_response";
    }
    @GetMapping("/emailResponse")
    public String emailException() {

        return "email_response";
    }

}
