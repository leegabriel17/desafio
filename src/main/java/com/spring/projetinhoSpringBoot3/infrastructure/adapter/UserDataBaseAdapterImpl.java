package com.spring.projetinhoSpringBoot3.infrastructure.adapter;

import com.spring.projetinhoSpringBoot3.domain.gateway.UserDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.UserAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataBaseAdapterImpl implements UserDataBaseGateway {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAdapterMapper userAdapterMapper;

    @Override
    public UserModel userSave(UserEntity userEntity) {
        return userAdapterMapper.toModel(userRepository.save(userEntity));
    }
}
