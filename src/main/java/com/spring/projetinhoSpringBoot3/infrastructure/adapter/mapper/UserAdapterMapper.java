package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserAdapterMapper {
    UserEntity toEntity (UserModel userModel);

    UserModel toModel (UserEntity userEntity);

    UserModel toModel(UserRequest userRequest);

}
