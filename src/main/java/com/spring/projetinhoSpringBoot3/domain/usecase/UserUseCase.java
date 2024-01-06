package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserUseCase{
    UserModel createUser (UserRequest userRequest);
}
