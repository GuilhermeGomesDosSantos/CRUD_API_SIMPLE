package com.example.api.user.User.API.controller;

import com.example.api.user.User.API.model.User.DtoUserDetails;
import com.example.api.user.User.API.model.User.DtoUserRegister;
import com.example.api.user.User.API.model.User.User;
import com.example.api.user.User.API.model.User.UserRepository;
import com.example.api.user.User.API.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping
@RestController
public class ControllerRegister {
    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    public ControllerRegister(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registerUsers")
    public ResponseEntity registerUser(@RequestBody @Valid DtoUserRegister dtoUserRegister, UriComponentsBuilder uriComponentsBuilder){
        User user = userService.createUser(dtoUserRegister);

        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DtoUserDetails(user));
    }

    @GetMapping("/users")
    public List<DtoUserDetails> getUsers(@PageableDefault(sort = {"id"})Pageable pageable){
        var users = userRepository.findAll(pageable).map(DtoUserDetails::new).toList();

        return users;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserId(@PathVariable Long id){
        var userId = userRepository.getReferenceById(id);

        return ResponseEntity.ok(new DtoUserDetails(userId));
    }

    @DeleteMapping("deleterUser/{id}")
    public ResponseEntity deleterUser (@PathVariable Long id){
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
