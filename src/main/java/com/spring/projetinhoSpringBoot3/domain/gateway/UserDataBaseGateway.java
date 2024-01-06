package com.spring.projetinhoSpringBoot3.domain.gateway;

import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;


public interface UserDataBaseGateway {
    UserModel userSave(UserEntity userEntity);
}