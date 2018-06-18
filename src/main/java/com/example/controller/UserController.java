package com.example.controller;

import com.example.model.Animal;
import com.example.model.User;
import com.example.model.Visit;
import com.example.service.AnimalService;
import com.example.service.UserService;
import com.example.service.VisitService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    AnimalService animalService;

    @Autowired
    UserService userService;

    @Autowired
    VisitService visitService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


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

    @RequestMapping(value = "user/visits", method = RequestMethod.GET)
    public ModelAndView visits()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userService.findUserByEmail(name);
        List<Visit> visits = visitService.findAllHistoricUsersVisits(user.getId());
        modelAndView.addObject("visits",visits);
        modelAndView.setViewName("user/visits");
        return modelAndView;
    }

    @RequestMapping(value = "user/details", method = RequestMethod.GET)
    public ModelAndView details()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userService.findUserByEmail(name);
        User editUser = new User();
        modelAndView.addObject("user",user);
        modelAndView.addObject("editUser",editUser);
        modelAndView.setViewName("user/details");
        return modelAndView;
    }
    @RequestMapping(value = "user/details",method = RequestMethod.POST)
    public ModelAndView changeDetails(@Valid User editUser, BindingResult bindingResult)
    {

        ModelAndView modelAndView = new ModelAndView();
        String errorMessage=null;
        String message="Dane użytkownika [email="+editUser.getEmail()+"] zostały zaktualizowane pomyślnie!";

        User user = userService.findById(editUser.getId());
        try {
            if (!(editUser.getName().equals(user.getName()))) {
                if (editUser.getName() == null)
                {
                    errorMessage = "Pole nazwisko nie może być puste!";
                    throw new Exception();
                }else
                user.setName(editUser.getName());
            }
            if(!(editUser.getLastName().equals(user.getLastName())))
            {
                if(editUser.getLastName()==null)
                {
                    errorMessage = "Pole \"Imię\" nie może być puste!";
                    throw new Exception();
                }else
                    user.setLastName(editUser.getLastName());
            }
            if(!(editUser.getCity().equals(user.getCity())))
            {
                if(editUser.getCity()==null)
                {
                    errorMessage = "Pole \"Miasto\" nie może byc puste!";
                    throw new Exception();
                }else
                    user.setCity(editUser.getCity());
            }
            if(!(editUser.getZipCode().equals(user.getZipCode())))
            {
                if(editUser.getZipCode()==null)
                {
                    errorMessage = "Pole \"Kod pocztowy\" nie może być puste!";
                    throw new Exception();
                }else
                    user.setZipCode(editUser.getZipCode());
            }
            if(!(editUser.getStreet().equals(user.getStreet())))
            {
                if(editUser.getStreet()==null)
                {
                    errorMessage = "Pole \"Ulica\" nie może być puste!";
                    throw new Exception();
                }else
                    user.setStreet(editUser.getStreet());
            }
            if(!(editUser.getBuilding().equals(user.getBuilding())))
            {
                if(editUser.getBuilding()==null)
                {
                    errorMessage = "Pole \"Budynek\" nie może być puste!";
                    throw new Exception();
                }else
                    user.setBuilding(editUser.getBuilding());
            }
            if(!(editUser.getFlat().equals(user.getFlat())))
            {
                if(editUser.getFlat()==null)
                {
                    errorMessage = "Pole \"Mieszkanie\" nie może byc puste!";
                    throw new Exception();
                }else
                    user.setFlat(editUser.getFlat());
            }
            if(!(editUser.getPhone().equals(user.getPhone())))
            {
                if(editUser.getPhone()==null)
                {
                    errorMessage = "Pole \"Numer telefonu\" nie może byc puste!";
                    throw new Exception();
                }else
                    user.setPhone(editUser.getPhone());
            }
            userService.updateUser(user);
        }catch(Exception ex)
        {
            modelAndView.addObject("errorMessage",errorMessage);
            message=null;
        }finally {

            modelAndView.addObject("message",message);
            user = userService.findUserByEmail(user.getEmail());
            modelAndView.addObject("user",user);
            modelAndView.addObject("editUser",new User());
            modelAndView.setViewName("user/details");
            return modelAndView;
        }

    }
    @RequestMapping(value = "user/details/resetPassword",method = RequestMethod.POST)
    public ModelAndView resetPassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword1") String newPassword1, @RequestParam("newPassword") String newPassword, @RequestParam("id") long id)
    {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findById(id);
        String message = "Hasło zostało zmienione pomyślnie!";
        if(bCryptPasswordEncoder.matches(oldPassword,user.getPassword()))
        {
          user.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userService.updateUser(user);
        }
        user = userService.findById(id);
        modelAndView.addObject("user",user);
        modelAndView.addObject("editUser",new User());
        modelAndView.addObject("message",message);

        modelAndView.setViewName("user/details");
        return modelAndView;
    }

    @RequestMapping(value="user/index", method = RequestMethod.GET)
    public ModelAndView userIndex()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/index");
        return modelAndView;
    }
}
