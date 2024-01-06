package com.spring.projetinhoSpringBoot3.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long userId;
    @NotNull
    private String userName;
    @NotNull
    private String cpf;
    private String email;
    private String password;
}
