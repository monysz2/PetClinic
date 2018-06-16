package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ModelAndView listUsers()
    {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        Set<User> users = userService.findAllUsersById();
        List<Role> roles = roleService.findAll();
        modelAndView.addObject("roles",roles);
        modelAndView.addObject("users",users);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/users");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/users",method = RequestMethod.POST)
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();


        try
        {
            userService.saveUser(user);
            String message = "User [email="+user.getEmail()+"] has been added successfully!";
            modelAndView.addObject("message",message);
        }catch(Exception e)
        {
            String errorMessage = "User with [email="+user.getEmail()+"] already exists!";
            modelAndView.addObject("errorMessage",errorMessage);
        }finally
        {
            Set<User> users = userService.findAllUsersById();
            List<Role> roles = roleService.findAll();
            modelAndView.addObject("roles",roles);
            modelAndView.addObject("users", users);
            modelAndView.addObject("user",new User());
            modelAndView.setViewName("admin/users");
            return modelAndView;
        }


    }

    @RequestMapping(value = "/admin/users/del={id}",method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id)
    {
        ModelAndView modelAndView = new ModelAndView();
        String message = "User [ID="+id+"] has been deleted successfully";
        try{
            userService.deleteUser(id);
        }catch (Exception e)
        {
            String errorMessage = "User [ID="+id+"] cannot be deleted!";
            message = null;
            modelAndView.addObject("errorMessage",errorMessage);
        }finally {

            Set<User> users = userService.findAllUsersById();
            List<Role> roles = roleService.findAll();
            modelAndView.addObject("roles",roles);
            modelAndView.addObject("users",users);
            modelAndView.addObject("user",new User());
            modelAndView.addObject("message",message);
            modelAndView.setViewName("admin/users");
            return modelAndView;
        }
    }

}
