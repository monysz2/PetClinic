package com.example.controller;

import com.example.model.Animal;
import com.example.model.User;
import com.example.service.AnimalService;
import com.example.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    AnimalService animalService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "user/myPets", method = RequestMethod.GET)
    public ModelAndView myPets()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userService.findUserByEmail(name);
        List<Animal> animals = animalService.findUsersAnimals(user.getId());
        modelAndView.addObject("pets",animals);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/myPets");
        return modelAndView;
    }
}
