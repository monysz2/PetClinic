package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ModelAndView listUsers()
    {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        Set<User> users = userService.findAllUsersById();
        modelAndView.addObject("users",users);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/users");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/users",method = RequestMethod.POST)
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();
        User toUpdate = userService.findUserByEmail(user.getEmail());
        toUpdate.setBuilding(user.getBuilding());
        toUpdate.setFlat(user.getFlat());
        toUpdate.setCity(user.getCity());
        toUpdate.setZipCode(user.getZipCode());
        toUpdate.setPesel(user.getPesel());
        toUpdate.setPhone(user.getPhone());
        userService.saveUser(toUpdate);
        Set<User> users = userService.findAllUsersById();
        modelAndView.addObject("users", users);
        modelAndView.addObject("user",new User());
        modelAndView.setViewName("admin/users");
        return modelAndView;

    }

}
