package com.janiv.api.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janiv.api.model.User;
import com.janiv.api.repository.UsersRepository;

@Validated
@RestController
@RequestMapping("/api/signin")
public class SignInController {

    private final UsersRepository repository;

    private final PasswordEncoder passwordEncoder;

    public SignInController(UsersRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    User signin(@RequestParam String email, @RequestParam String password) {
        //User u = new User(null, email, passwordEncoder.encode(password), User.Role.USER0, 0D, null);
        //return repository.save(u);
        
    	//TODO : Sign in code will go here (?)
        return null;
    }

    /*
    @PostMapping("/validateEmail")
    Boolean emailExists(@RequestParam String email) {
        return repository.existsByEmail(email);
    }
    */

}