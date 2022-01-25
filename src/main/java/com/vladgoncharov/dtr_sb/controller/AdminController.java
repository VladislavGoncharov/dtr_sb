package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.UserRole;
import com.vladgoncharov.dtr_sb.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    private UserServiceInterface userDetailsService;

    @PostMapping(value = "/adminPage")
    public String adminPage(Model model) {

        List<UserRole> allUsers = userDetailsService.getAllUsers();
        model.addAttribute("users", allUsers);

        return "admin_page";
    }

    @GetMapping("/registrationModerator")
    public String registrationModerator(Model model) {
        model.addAttribute("user", new AppUser());
        return "registration_moderator";
    }

    @PostMapping("/registrationModerator")
    public String saveModerator(@Valid @ModelAttribute("user") AppUser user
            , BindingResult bindingResult, Model model) {

        AppUser appUser = userDetailsService.findUserAccount(user.getUserName());

        if (bindingResult.hasErrors()) {
            return "registration_moderator";
        }
        if (appUser != null){
            model.addAttribute("exceptionUserName"," такой пользователь уже существует");
            return "registration_moderator";
        }
        if (!user.getEncrytedPassword().equals(user.getEncrytedPasswordCheck())) {
            model.addAttribute("exceptionPasswordCheck"," пароли не совпадают");
            return "registration_moderator";
        }
        userDetailsService.saveModerator(user);

        return "redirect:/admin/adminPage";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id) {
        userDetailsService.deleteUser(id);
        return "redirect:/admin/adminPage";
    }

    @PostMapping("/blockUser")
    public String blockUser(@RequestParam("userId") long id) {
        userDetailsService.blockUser(id);
        return "redirect:/admin/adminPage";
    }
}
