package com.spring.projetinhoSpringBoot3.infrastructure.adapter;

import com.spring.projetinhoSpringBoot3.domain.gateway.OrderDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrderAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrdersItemAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDataBaseAdapterImpl implements OrderDataBaseGateway {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderAdapterMapper orderAdapterMapper;
    @Autowired
    private OrdersItemAdapterMapper ordersItemAdapterMapper;

    @Override
    public OrderEntity orderSave(OrderEntity orderEntity) {

        return orderRepository.save(orderEntity);
    }
}
