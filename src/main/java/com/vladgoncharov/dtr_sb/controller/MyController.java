package com.vladgoncharov.dtr_sb.controller;

import com.vladgoncharov.dtr_sb.dao.UserDAO;
import com.vladgoncharov.dtr_sb.entity.AppUser;
import com.vladgoncharov.dtr_sb.working_with_a_date.DateDifference;
import com.vladgoncharov.dtr_sb.working_with_a_date.TimeDifference;
import com.vladgoncharov.dtr_sb.working_with_a_date.TimeUnitConverter;
import com.vladgoncharov.dtr_sb.working_with_a_date.WorkingDaysAndWeekends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class MyController {


    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public String firstView(Model model, Principal principal) {

        if (principal == null)
        model.addAttribute("userName", "Гость");

        if (principal != null)
        model.addAttribute("userName",principal.getName() );

        return "first-view";
    }

    @RequestMapping("changeTheDate")
    public String changeTheDate(Model model) {

        model.addAttribute("dateDifference", new DateDifference());

        return "change-the-date";
    }

    @RequestMapping("changeTheDateResult")
    public String changeTheDateResult(@Valid @ModelAttribute("dateDifference") DateDifference date, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "change-the-date";
        } else {
            try {
                date.methodGetTheDateDifference();
            } catch (Exception e) {
                return "change-the-date-exception";
            }
            return "change-the-date-result";
        }
    }

    @RequestMapping("changeTheDateException")
    public String changeTheDateException() {
        return "change-the-date-exception";
    }

    @RequestMapping("changeTheTime")
    public String changeTheTime(Model model) {

        model.addAttribute("timeDifference", new TimeDifference());

        return "change-the-time";
    }

//    @RequestMapping("changeTheTimeResult")
//    public String changeTheTimeResult(@ModelAttribute("timeDifference") TimeDifference time) {
//        time.theResultOfWorkingWithTime();
//        return "change-the-time-result";
//
//    }

    @RequestMapping("changeTheTimeResult")
    public String changeTheTimeResult(@ModelAttribute("timeDifference") TimeDifference time) {
        time.theResultOfWorkingWithTime();
        return "change-the-time-result";

    }

    @RequestMapping("timeUnitConverted")
    public String timeUnitConverted(Model model) {
        model.addAttribute("timeUnitConverted", new TimeUnitConverter());
        return "time-unit-converted";
    }

    @RequestMapping("timeUnitConvertedResult")
    public String timeUnitConvertedResult(@ModelAttribute("timeUnitConverted") TimeUnitConverter time) {
        time.theResultOfWorkingWithTime();
        return "time-unit-converted-result";
    }

    @RequestMapping("workingDaysAndWeekends")
    public String workingDaysAndWeekends(Model model){
        model.addAttribute("workingDaysAndWeekends",new WorkingDaysAndWeekends());
        return "working-days-and-weekends";
    }

    @RequestMapping("workingDaysAndWeekendsResult")
    public String workingDaysAndWeekendsResult(@Valid @ModelAttribute("workingDaysAndWeekends")
           WorkingDaysAndWeekends workingDaysAndWeekends, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "working-days-and-weekends";
        }
        else try{
            workingDaysAndWeekends.theResultOfWorkingWithTime();
        } catch (Exception e){
            e.printStackTrace();
            return "change-the-date-exception";
        }
        return "working-days-and-weekends-result";

    }
}
