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

    @GetMapping(value = "/adminPage")
    public String adminPage(Model model) {

        long NOM = userDetailsService.getNumberOfUser("MODERATOR");
        long NOU = userDetailsService.getNumberOfUser("USER");

        model.addAttribute("numberOfModerators",NOM);
        model.addAttribute("numberOfUsers",NOU);

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

        AppUser appUser = (AppUser) userDetailsService.findUserAccount(user.getUserName());

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

    @GetMapping("/showUSER")
    public String showUser(Model model) {

        List<UserRole> allUsers = userDetailsService.getAllUsers("USER");
        model.addAttribute("users", allUsers);
        model.addAttribute("text", "Количество пользователей: "+allUsers.size());

        return "show-user";
    }

    @GetMapping("/showMODERATOR")
    public String showModerator(Model model) {

        List<UserRole> allUsers = userDetailsService.getAllUsers("MODERATOR");
        model.addAttribute("users", allUsers);
        model.addAttribute("text", "Количество модераторов: "+allUsers.size());

        return "show-user";
    }

    @RequestMapping("/showUser/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        UserRole user = userDetailsService.findUserById(id);

        userDetailsService.deleteUser(id);

        return "redirect:/admin/show"+ user.getRoleName().substring(5);
    }

    @RequestMapping("/showUser/blockUser/{id}")
    public String blockUser(@PathVariable long id) {
        UserRole user = userDetailsService.findUserById(id);

        userDetailsService.blockUser(id);

        return "redirect:/admin/show"+ user.getRoleName().substring(5);
    }
}
