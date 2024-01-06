package com.spring.projetinhoSpringBoot3.domain.gateway;

import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;

import java.util.List;


public interface OrdersItemDataBaseGateway {
    void ordersItemSave(OrdersItemEntity ordersItemEntity);
}