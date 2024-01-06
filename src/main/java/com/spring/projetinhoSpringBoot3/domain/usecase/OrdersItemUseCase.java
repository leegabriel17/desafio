package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrdersItemRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface OrdersItemUseCase {

    OrdersItemModel createOrdersItem (OrderEntity orderEntity, OrdersItemRequest ordersItemRequest, BigDecimal frete, int serviceCharge, BigDecimal discount, BigDecimal valueTotal, BigDecimal valueTotalUser);

    //List<OrdersItemModel> createOrdersItem(OrderEntity orderEntity, OrderRequest orderRequest, BigDecimal valueTotal);
}
