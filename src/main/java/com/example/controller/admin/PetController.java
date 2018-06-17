package com.example.controller.admin;

import com.example.common.enums.AnimalSex;
import com.example.common.enums.AnimalType;
import com.example.model.Animal;
import com.example.model.User;
import com.example.service.AnimalService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PetController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/pets", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView();
        Animal pet = new Animal();
        List<Animal> pets = animalService.findAll();
        List<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        modelAndView.addObject("pets", pets);
        modelAndView.addObject("pet", pet);
        modelAndView.addObject("sexDic", AnimalSex.values());
        modelAndView.addObject("animalType", AnimalType.values());

        modelAndView.setViewName("admin/pets");

        return modelAndView;
    }

    @RequestMapping(value = "/admin/pets", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid Animal pet, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            animalService.saveAnimal(pet);

            String message = "Pet [name=" + pet.getName() + "] has been added successfully!";
            modelAndView.addObject("message", message);
        } catch (Exception e) {
            String errorMessage = "Adding animal [name=" + pet.getName() + "] failed!";
            modelAndView.addObject("errorMessage", errorMessage);
        } finally {
            List<Animal> pets = animalService.findAll();
            List<User> users = userService.findAll();
            modelAndView.addObject("users", users);
            modelAndView.addObject("pets", pets);
            modelAndView.addObject("pet", new Animal());
            modelAndView.addObject("sexDic", AnimalSex.values());
            modelAndView.addObject("animalType", AnimalType.values());
            modelAndView.setViewName("admin/pets");

            return modelAndView;
        }


    }

}
