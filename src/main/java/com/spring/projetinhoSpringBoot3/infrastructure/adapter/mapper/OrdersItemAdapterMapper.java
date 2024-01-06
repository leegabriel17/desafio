package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrdersItemRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.List;

@Component
public interface OrdersItemAdapterMapper {
    OrdersItemEntity toEntity (OrdersItemModel ordersItemModel, List<ProductEntity> productEntityList, UserEntity userEntity);

    OrdersItemModel toModel (OrdersItemEntity ordersItemEntity, List<ProductModel> productModelList, UserModel userModel);

    OrdersItemResponse toResponse(OrdersItemModel ordersItemModel);

    OrdersItemEntity toEntity (OrdersItemModel ordersItemModel);

    OrdersItemModel toModel(OrdersItemRequest ordersItemRequest,BigDecimal valueTotalUser,String urlPayment);

    OrdersItemModel toModel(OrdersItemRequest ordersItemRequest);

}
