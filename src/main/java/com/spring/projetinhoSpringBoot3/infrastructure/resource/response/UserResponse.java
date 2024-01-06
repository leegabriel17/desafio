package com.spring.projetinhoSpringBoot3.infrastructure.resource.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Setter;

@Setter
@JsonSerialize
public class UserResponse {
    private String userName;
    private String email;

}
