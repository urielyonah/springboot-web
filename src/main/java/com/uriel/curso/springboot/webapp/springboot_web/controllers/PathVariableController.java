package com.uriel.curso.springboot.webapp.springboot_web.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.uriel.curso.springboot.webapp.springboot_web.models.User;
import com.uriel.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',') }")
    private List<String> valueList;

    @Value("#{ '${config.listOfValues}'.toUpperCase() }")
    private String valueString;

    @Value("#{ ${config.valuesMap} }")
    private Map<String, Object> valuesMap;

    @Value("#{ ${config.valuesMap}.product }")
    private String product;

    @Value("#{ ${config.valuesMap}.price }")
    private Long price;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto params = new ParamDto();
        params.setMessage(message);
        return params;
    }
    
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        
        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message ) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }
    

}
