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

        model.addAttribute("numberOfModerators", userDetailsService.getNumberOfUser("MODERATOR"));
        model.addAttribute("numberOfUsers", userDetailsService.getNumberOfUser("USER"));

        return "admin_page";
    }

    @GetMapping("/registrationModerator")
    public String registrationModerator(Model model) {
        model.addAttribute("moderator", new AppUser());
        return "registration_moderator";
    }

    @PostMapping("/registrationModerator")
    public String saveModerator(@Valid @ModelAttribute("moderator") AppUser moderator
            , BindingResult bindingResult, Model model) {

        AppUser appUser = (AppUser) userDetailsService.findUserByAccount(moderator.getUsername());

        if (bindingResult.hasErrors()) {
            return "registration_moderator";
        }
        if (appUser != null) {
            model.addAttribute("exceptionUsername", "такой пользователь уже существует");
            return "registration_moderator";
        }
        if (!moderator.getEncrytedPassword().equals(moderator.getEncrytedPasswordCheck())) {
            model.addAttribute("exceptionPasswordCheck", "пароли не совпадают");
            return "registration_moderator";
        }

        userDetailsService.saveUser(moderator, "ROLE_MODERATOR");
        return "redirect:/admin/adminPage";
    }

    @GetMapping("/show{roleName}")
    public String showUser(@PathVariable("roleName") String roleName, Model model) {

        List<UserRole> allUsers;

        if (roleName.equals("MODERATOR")){
            allUsers = userDetailsService.getAllUsers("MODERATOR");
            model.addAttribute("text", "Количество модераторов: " + allUsers.size());
        }
        else {
            allUsers = userDetailsService.getAllUsers("USER");
            model.addAttribute("text", "Количество пользователей: " + allUsers.size());
        }

        model.addAttribute("users", allUsers);
        return "show-user";
    }

    @RequestMapping("/showUser/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        UserRole user = userDetailsService.findUserById(id);

        userDetailsService.deleteUser(id);
        //Чтобы не дублировать код: showUSER or showMODERATOR
        return "redirect:/admin/show" + user.getRoleName().substring(5);
    }

    @RequestMapping("/showUser/blockUser/{id}")
    public String blockUser(@PathVariable long id) {
        UserRole user = userDetailsService.findUserById(id);

        userDetailsService.blockUser(id);
        //Чтобы не дублировать код: showUSER or showMODERATOR
        return "redirect:/admin/show" + user.getRoleName().substring(5);
    }
}
