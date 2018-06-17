package com.example.controller.admin;

import com.example.common.enums.AnimalSex;
import com.example.common.enums.AnimalType;
import com.example.common.enums.WorkingHours;
import com.example.model.Animal;
import com.example.model.User;
import com.example.model.Visit;
import com.example.service.AnimalService;
import com.example.service.UserService;
import com.example.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class VisitController {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/admin/visits", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView();
        Visit visit = new Visit();
        visit.setDate(new Date());
        List<Animal> pets = animalService.findAll();
        List<Visit> visits = visitService.findAll();

        modelAndView.addObject("pets", pets);
        modelAndView.addObject("visit", visit);
        modelAndView.addObject("visits", visits);
        modelAndView.addObject("hours", WorkingHours.values());

        modelAndView.setViewName("admin/visits");

        return modelAndView;
    }

    @RequestMapping(value = "/admin/visits", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid Visit visit, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            visitService.saveVisit(visit);

            String message = "Visit [desc=" + visit.getDescription() + "] has been added successfully!";
            modelAndView.addObject("message", message);
        } catch (Exception e) {
            String errorMessage = "Visit [desc=" + visit.getDescription() + "] failed!";
            modelAndView.addObject("errorMessage", errorMessage);
        } finally {
            List<Animal> pets = animalService.findAll();
            List<Visit> visits = visitService.findAll();
            modelAndView.addObject("pets", pets);
            modelAndView.addObject("visit", visit);
            modelAndView.addObject("visits", visits);
            modelAndView.addObject("hours", WorkingHours.values());

            modelAndView.setViewName("admin/visits");

            return modelAndView;
        }
    }
}
