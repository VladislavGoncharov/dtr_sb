package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.entity.Comment;
import com.vladgoncharov.dtr_sb.service.CommentService;
import com.vladgoncharov.dtr_sb.service.UserServiceInterface;
import com.vladgoncharov.dtr_sb.working_with_a_date.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.DateTimeException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String firstView(Model model, Principal principal) {

        if (principal != null) {
            AppUser user = (AppUser) userServiceInterface.findUserByAccount(principal.getName());

            model.addAttribute("theUserIsReadyToCheckEmail"
                    , user.getAppUserInfo().theUserIsReadyToCheckEmail());
            model.addAttribute("comment", new Comment());
            model.addAttribute("currentUsername", principal.getName());
        }

        List<Comment> allComments = commentService.getAllComments();
        model.addAttribute("comments", allComments);
        model.addAttribute("arrayRoleName", new String[]{"user", "moderator", "admin"});

        return "first-view";
    }

    @GetMapping("dateDifference")
    public String changeTheDate(Model model) {
        model.addAttribute("dateDifference", new DateDifference());
        return "date-difference";
    }

    @GetMapping("dateDifferenceResult")
    public String changeTheDateResult(@Valid @ModelAttribute("dateDifference") DateDifference dateDifference
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "date-difference-result";
        }

        try {
            dateDifference.getResult();
        } catch (Exception e) {
            return "change-the-date-exception";
        }

        return "date-difference-result";
    }

    @GetMapping("timeDifference")
    public String changeTheTime(Model model) {
        model.addAttribute("timeDifference", new TimeDifference());
        return "time-difference";
    }

    @GetMapping("timeDifferenceResult")
    public String changeTheTimeResult(@ModelAttribute("timeDifference") TimeDifference timeDifference) {
        timeDifference.getResult();
        return "time-difference-result";
    }

    @GetMapping("timeUnitConverted")
    public String timeUnitConverted(Model model) {
        model.addAttribute("timeUnitConverted", new TimeUnitConverter());
        return "time-unit-converted";
    }

    @GetMapping("timeUnitConvertedResult")
    public String timeUnitConvertedResult(@ModelAttribute("timeUnitConverted") TimeUnitConverter timeUnitConverted) {
        timeUnitConverted.getResult();
        return "time-unit-converted-result";
    }


    @GetMapping("workingDaysAndWeekends")
    public String workingDaysAndWeekends(Model model) {
        model.addAttribute("workingDaysAndWeekends", new WorkingDaysAndWeekends());
        return "working-days-and-weekends";
    }

    @GetMapping("workingDaysAndWeekendsResult")
    public String workingDaysAndWeekendsResult(
            @Valid @ModelAttribute("workingDaysAndWeekends") WorkingDaysAndWeekends workingDaysAndWeekends
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "working-days-and-weekends";
        }

        try {
            workingDaysAndWeekends.getResult();
        } catch (Exception e) {
            e.printStackTrace();
            return "change-the-date-exception";
        }

        return "working-days-and-weekends-result";

    }

    @GetMapping("zodiacSign")
    public String zodiacSign(Model model) {
        model.addAttribute("zodiacSign", new ZodiacSign());
        return "zodiac-sign";
    }

    @PostMapping("zodiacSignResult")
    public String zodiacSignResult(@ModelAttribute("zodiacSign") ZodiacSign zodiacSign) {

        try {
            zodiacSign.getResult();
        } catch (DateTimeException e) {
            return "change-the-date-exception";
        }

        return "zodiac-sign-result";
    }

    @GetMapping("chineseZodiac")
    public String chineseZodiac(Model model) {
        model.addAttribute("chineseZodiac", new ChineseZodiac());
        return "chinese-zodiac";
    }

    @PostMapping("chineseZodiacResult")
    public String chineseZodiacResult(@ModelAttribute("chineseZodiac") ChineseZodiac chineseZodiac) {

        try {
            chineseZodiac.getResult();
        } catch (Exception e) {
            return "change-the-date-exception";
        }

        return "chinese-zodiac-result";
    }

    @GetMapping("pharmacyCalculation")
    public String pharmacyCalculation(Model model) {
        model.addAttribute("pharmacyCalculation", new PharmacyCalculation());
        return "pharmacy-calculation";
    }

    @GetMapping("pharmacyCalculationResult")
    public String pharmacyCalculationResult(@ModelAttribute("pharmacyCalculation")
                                                        PharmacyCalculation pharmacyCalculation) {
        pharmacyCalculation.getResult();
        return "pharmacy-calculation-result";
    }
}
