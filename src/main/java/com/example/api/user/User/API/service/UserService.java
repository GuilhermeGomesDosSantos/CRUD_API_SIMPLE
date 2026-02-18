package com.example.api.user.User.API.service;

import com.example.api.user.User.API.model.Endereco.Endereco;
import com.example.api.user.User.API.model.User.DtoUserRegister;
import com.example.api.user.User.API.model.User.User;
import com.example.api.user.User.API.model.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(DtoUserRegister dtoUserRegister) {
        User user = new User();
        user.setNome(dtoUserRegister.nome());
        user.setEmail(generatedEmail(dtoUserRegister.nome()));
        user.setIdade(dtoUserRegister.idade());
        user.setEndereco(new Endereco(dtoUserRegister.dtoEnderecoRegister()));

        return userRepository.save(user);
    }
    public String generatedEmail(String nome){
        String[] partesNomes = nome.toLowerCase().strip().split("\\s+");
        System.out.println(partesNomes);
        String firstName = partesNomes[0];
        String secondName = partesNomes.length > 1 ? partesNomes[partesNomes.length -1] : partesNomes[0];
        String email = firstName + "." + secondName + "@email.teste.com";

        if (userRepository.findByEmail(email).isPresent()){
            var random = new Random().nextInt(100);
            return firstName + "." + secondName + random + "@email.teste.com";
        }
        System.out.println(email);
        return email;
    }
}