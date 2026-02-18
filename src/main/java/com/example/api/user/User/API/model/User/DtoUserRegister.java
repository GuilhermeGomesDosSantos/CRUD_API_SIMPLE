package com.example.api.user.User.API.model.User;

import com.example.api.user.User.API.model.Endereco.DtoEnderecoRegister;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoUserRegister(
        @NotBlank
        String nome,
        @NotNull
        int idade,
        @NotNull
        @Valid
        DtoEnderecoRegister dtoEnderecoRegister
) {
}
