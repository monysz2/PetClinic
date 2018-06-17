package com.example.controller.admin;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class AdminIndexController {
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public ModelAndView listUsers()
    {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
