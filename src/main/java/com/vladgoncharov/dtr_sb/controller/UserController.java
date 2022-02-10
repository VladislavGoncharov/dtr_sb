package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.AppUserInfo;
import com.vladgoncharov.dtr_sb.service.EmailSenderService;
import com.vladgoncharov.dtr_sb.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
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
    private EmailSenderService emailSenderService;


    @GetMapping("/registration")
    public String registrationUser(Model model) {
        model.addAttribute("user", new AppUser());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user
            , Model model, BindingResult bindingResult) {

        AppUser appUser = (AppUser) userServiceInterface.findUserByAccount(user.getUsername());


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
        userServiceInterface.saveUser(user, "ROLE_USER");
        return "redirect:/";
    }


    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @GetMapping("/userInfo_{username}")
    public String userInfo(@PathVariable("username") String username
            , Model model, Principal principal) {

        AppUser user = (AppUser) userServiceInterface.findUserByAccount(username);
        model.addAttribute("userInfo", user.getAppUserInfo());
        model.addAttribute("username", username);

        /* Конструкция служить для того, чтобы давать право изменять свои данные.
         * Пользователь имеет право изменять только свои данные */
        try {
            model.addAttribute("currentUsername", principal.getName());
        } finally {
            return "user_info";
        }
    }

    @PostMapping("/userInfo_{username}")
    public String userInfoSave(@PathVariable("username") String username,
                               @Valid @ModelAttribute("appUserInfo") AppUserInfo userInfo,
                               BindingResult bindingResult, Model model,
                               Principal principal) {
        System.out.println(bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {

            AppUser user = (AppUser) userServiceInterface.findUserByAccount(principal.getName());

            model.addAttribute("userInfo", user.getAppUserInfo());
            model.addAttribute("currentUsername", principal.getName());
            System.out.println("return user_info_update");
            return "user_info_update";
        }
        userServiceInterface.updateInfo(userInfo);

        model.addAttribute("username", username);
        model.addAttribute("userInfo", userInfo);
        System.out.println("return user_info");

        /* Конструкция служить для того, чтобы давать право изменять свои данные.
         * Пользователь имеет право изменять только свои данные */
        try {
            model.addAttribute("currentUsername", principal.getName());
        } finally {
            return "user_info";
        }
    }

    @GetMapping("/updateUserInfo{isClear}")
    public String userInfoUpdate(@PathVariable String isClear,
                                 Model model, Principal principal) {

        AppUser user = (AppUser) userServiceInterface.findUserByAccount(principal.getName());

        if (!isClear.isEmpty()) {
            long id = user.getAppUserInfo().getId();
            user.setAppUserInfo(new AppUserInfo(id));
        }

        model.addAttribute("appUserInfo", user.getAppUserInfo());
        model.addAttribute("currentUsername", principal.getName());

        return "user_info_update";
    }

    @GetMapping("/checkingEmail_{currentUsername}")
    public String checkingEmail(@PathVariable String currentUsername, Model model) {

        AppUser user = (AppUser) userServiceInterface.findUserByAccount(currentUsername);
        try {

            emailSenderService.sendEmail(user.getAppUserInfo().getEmail(), currentUsername);

        } catch (MailParseException exception) {
            /* Если пользователь все таки ввел некорректный email,
            * то выйдет ошибка, где будет ему об этом сказано */
            exception.printStackTrace();
            model.addAttribute("isSuccessful", false);
            return "email_response";
        }

        return "redirect:/";
    }

    //Удачное подтверждение email
    @GetMapping("/confirmYourEmailAddress_{currentUsername}")
    public String confirmYourEmailAddress(@PathVariable String currentUsername, Model model) {

        emailSenderService.confirmYourEmailAddress(currentUsername);
        model.addAttribute("isSuccessful", true);

        return "email_response";
    }
}
