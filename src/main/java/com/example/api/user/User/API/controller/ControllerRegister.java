package com.example.api.user.User.API.controller;

import com.example.api.user.User.API.model.User.DtoUserDetails;
import com.example.api.user.User.API.model.User.DtoUserRegister;
import com.example.api.user.User.API.model.User.User;
import com.example.api.user.User.API.model.User.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping
@RestController
public class ControllerRegister {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/registerUsers")
    public ResponseEntity registerUser(@RequestBody @Valid DtoUserRegister dtoUserRegister, UriComponentsBuilder uriComponentsBuilder){
        var newUser = new User(dtoUserRegister);

        userRepository.save(newUser);

        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(new DtoUserDetails(newUser));
    }

}
