package com.uriel.curso.springboot.webapp.springboot_web.controllers;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uriel.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Uriel", "Arce");
        user.setEmail("uriel@yonah.com");
        model.addAttribute("title", "Hola mundo SpringBoot");
        model.addAttribute("user", user);
        
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }
    
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
            new User("pepa", "gonzalez", "pepa@gmail.com"),
            new User("Pedro", "Arcera"),
            new User("Carlos", "Berthold") 
        );
    }
}
