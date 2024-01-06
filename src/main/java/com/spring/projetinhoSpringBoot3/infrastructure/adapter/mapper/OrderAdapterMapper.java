package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrderResponse;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderAdapterMapper {
    OrderEntity toEntity (OrderModel orderModel,List<OrdersItemEntity> ordersItemEntityList);
    OrderEntity toEntity (OrderModel orderModel);
    OrderModel toModel (OrderEntity orderEntity);
    OrderModel toModel(OrderRequest orderRequest,List<OrdersItemModel> ordersItemModelList);
    OrderModel toModel(OrderRequest orderRequest);
    OrderResponse toResponse(OrderModel orderModel,List<OrdersItemResponse> ordersItemResponseList);
}
