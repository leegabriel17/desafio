package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.gateway.UserDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.UserAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUseCaseImpl implements UserUseCase{

    @Autowired
    private UserAdapterMapper userAdapterMapper;

    @Autowired
    private UserDataBaseGateway userDataBaseGateway;

    @Override
    public UserModel createUser(UserRequest userRequest) {
        final UserModel userModel = userAdapterMapper.toModel(userRequest);
        return userDataBaseGateway.userSave(userAdapterMapper.toEntity(userModel));
    }


}
