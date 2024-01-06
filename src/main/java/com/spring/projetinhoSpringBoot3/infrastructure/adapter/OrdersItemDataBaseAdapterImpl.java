package com.spring.projetinhoSpringBoot3.infrastructure.adapter;

import com.spring.projetinhoSpringBoot3.domain.gateway.OrdersItemDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrdersItemAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository.OrdersItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersItemDataBaseAdapterImpl implements OrdersItemDataBaseGateway {
    @Autowired
    private OrdersItemRepository ordersItemRepository;

    @Autowired
    private OrdersItemAdapterMapper ordersItemAdapterMapper;

    @Override
    public void ordersItemSave(OrdersItemEntity ordersItemEntity) {
        ordersItemRepository.save(ordersItemEntity);
    }
}
