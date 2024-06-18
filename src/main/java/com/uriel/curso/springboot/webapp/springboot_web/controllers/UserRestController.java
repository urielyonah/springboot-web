package com.uriel.curso.springboot.webapp.springboot_web.controllers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uriel.curso.springboot.webapp.springboot_web.models.User;
import com.uriel.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Uriel", "Arce");
        userDto.setTitle("Hola mundo con SpringBoot");
        userDto.setUser(user);
    
        return userDto;
    }

    @GetMapping("/list")
    public List<User> List(){
        User user = new User("Uriel", "Arce");
        User user2 = new User("Yonah", "Ortiz");
        User user3 = new User("John", "Doe");

        List<User> users = Arrays.asList(user,user2,user3);
        /* List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        */

        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){
        User user = new User("Uriel", "Arce");
        Map<String, Object> body= new HashMap<>();
        body.put("title", "Hola mundo SpringBoot");
        body.put("user", user);

        return body;
    } 
}



