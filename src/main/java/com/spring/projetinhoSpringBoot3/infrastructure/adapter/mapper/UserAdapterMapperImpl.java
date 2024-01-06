package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserAdapterMapperImpl implements UserAdapterMapper{

    @Override
    public UserEntity toEntity (UserModel userModel){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userModel.getUserId());
        userEntity.setUserName(userModel.getUserName());
        userEntity.setCpf(userModel.getCpf());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPassword(userModel.getPassword());
        return userEntity;
    }

    @Override
    public UserModel toModel (UserEntity userEntity){
        UserModel userModel = new UserModel();
        userModel.setUserName(userEntity.getUserName());
        userModel.setEmail(userEntity.getEmail());
        return userModel;
    }

    @Override
    public UserModel toModel(UserRequest userRequest){
        UserModel userModel = new UserModel();
        userModel.setUserId(userRequest.userId());
        userModel.setUserName(userRequest.userName());
        userModel.setCpf(userRequest.cpf());
        userModel.setEmail(userRequest.email());
        userModel.setPassword(userRequest.password());
        return userModel;
    }

}
