package com.spring.projetinhoSpringBoot3.domain.gateway;

import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;

import java.util.List;


public interface OrderDataBaseGateway {
    OrderEntity orderSave(OrderEntity orderEntity);
}