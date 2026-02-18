package com.example.api.user.User.API.controller;

import com.example.api.user.User.API.model.User.DtoUserDetails;
import com.example.api.user.User.API.model.User.DtoUserRegister;
import com.example.api.user.User.API.model.User.User;
import com.example.api.user.User.API.model.User.UserRepository;
import com.example.api.user.User.API.service.UserService;
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
//    @Autowired
//    UserRepository userRepository;
    private final UserService userService;

    public ControllerRegister(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registerUsers")
    public ResponseEntity registerUser(@RequestBody @Valid DtoUserRegister dtoUserRegister, UriComponentsBuilder uriComponentsBuilder){
//        var newUser = new User(dtoUserRegister);
//
//        userRepository.save(newUser);
        User user = userService.createUser(dtoUserRegister);

        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DtoUserDetails(user));
    }

}
