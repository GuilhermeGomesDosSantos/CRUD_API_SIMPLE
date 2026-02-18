package com.example.api.user.User.API.model.User;

import com.example.api.user.User.API.model.Endereco.Endereco;

public record DtoUserDetails(Long id, String nome, int idade, Endereco endereco) {
    public DtoUserDetails(User user){
        this(user.getId(), user.getNome(), user.getIdade(), user.getEndereco());
    }
}
