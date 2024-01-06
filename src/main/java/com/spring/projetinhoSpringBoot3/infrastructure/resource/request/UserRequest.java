package com.spring.projetinhoSpringBoot3.infrastructure.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UserRequest (
    @NotNull
    @JsonProperty(value = "userId")
    long userId,
    @NotNull
    @JsonProperty(value = "userName")
    String userName,
    @Valid
    @CPF
    @JsonProperty(value = "cpf")
    String cpf,
    @Valid
    @Email
    @JsonProperty(value = "email")
    String email,
    @NotNull
    @JsonProperty(value = "password")
    String password
){}
