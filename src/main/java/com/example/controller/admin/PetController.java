package com.example.controller.admin;

import com.example.model.Animal;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class PetController {

    @Autowired
    AnimalService animalService;

    @RequestMapping(value = "/admin/pets", method = RequestMethod.GET)
    public ModelAndView listUsers()
    {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    @RequestMapping(value = "/admin/pets",method = RequestMethod.POST)
    public ModelAndView addUser(@Valid Animal animal , BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();

        try
        {
            animalService.saveAnimal(animal);

            String message = "Animal [name="+animal.getName()+"] has been added successfully!";
            modelAndView.addObject("message",message);
        }catch(Exception e)
        {
            String errorMessage = "Adding animal [name="+animal.getName()+"] failed!";
            modelAndView.addObject("errorMessage",errorMessage);
        }finally
        {

            modelAndView.setViewName("admin/pets");
            return modelAndView;
        }


    }

}
