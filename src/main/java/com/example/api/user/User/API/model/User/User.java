package com.example.api.user.User.API.model.User;

import com.example.api.user.User.API.model.Endereco.Endereco;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private int idade;
    @Embedded
    private Endereco endereco;

    public User(){}
    public User(DtoUserRegister dtoUserRegister){
        this.nome = dtoUserRegister.nome();
//        this.email = generatedEmail(dtoUserRegister.nome());
        this.email = "teste";
        this.idade = dtoUserRegister.idade();
        this.endereco = new Endereco(dtoUserRegister.dtoEnderecoRegister());
    }

//    public String generatedEmail(String nome){
//        this.nome = nome;
//
//    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
