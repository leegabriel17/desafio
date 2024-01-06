package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrdersItemRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class OrdersItemAdapterMapperImpl implements OrdersItemAdapterMapper{

    @Override
    public OrdersItemEntity toEntity (OrdersItemModel ordersItemModel, List<ProductEntity> productEntityList, UserEntity userEntity){
        OrdersItemEntity ordersItemEntity = new OrdersItemEntity();
        ordersItemEntity.setProductEntityList(productEntityList);
        ordersItemEntity.setUserEntity(userEntity);
        ordersItemEntity.setValueTotalUser(ordersItemModel.getValueTotalUser());
        ordersItemEntity.setUrlPayment(ordersItemModel.getUrlPayment());
        return ordersItemEntity;
    }
    @Override
    public OrdersItemModel toModel (OrdersItemEntity ordersItemEntity, List<ProductModel> productModelList, UserModel userModel){
        OrdersItemModel ordersItemModel = new OrdersItemModel();
        ordersItemModel.setProductModelList(productModelList);
        ordersItemModel.setUserModel(userModel);
        ordersItemEntity.setValueTotalUser(ordersItemModel.getValueTotalUser());
        ordersItemEntity.setUrlPayment(ordersItemEntity.getUrlPayment());
        return ordersItemModel;
    }

    @Override
    public OrdersItemModel toModel(OrdersItemRequest ordersItemRequest,BigDecimal valueTotalUser,String urlPayment){
        OrdersItemModel ordersItemModel = new OrdersItemModel();
        ordersItemModel.setOrdersItemId(ordersItemRequest.ordersItemId());
        ordersItemModel.setProductModelList(Arrays.asList(ordersItemRequest.productModel()));
        ordersItemModel.setUserModel(ordersItemRequest.userModel());
        ordersItemModel.setValueTotalUser(valueTotalUser);
        ordersItemModel.setUrlPayment(urlPayment);
        return ordersItemModel;
    }

    @Override
    public OrdersItemModel toModel(OrdersItemRequest ordersItemRequest) {
        OrdersItemModel ordersItemModel = new OrdersItemModel();
        ordersItemModel.setOrdersItemId(ordersItemRequest.ordersItemId());
        ordersItemModel.setProductModelList(Arrays.asList(ordersItemRequest.productModel()));
        ordersItemModel.setUserModel(ordersItemRequest.userModel());
        return ordersItemModel;
    }

    @Override
    public OrdersItemResponse toResponse(OrdersItemModel ordersItemModel){
        OrdersItemResponse ordersItemResponse = new OrdersItemResponse();
        ordersItemResponse.setAmount(ordersItemModel.getValueTotalUser());
        ordersItemResponse.setUrlPagamento(ordersItemModel.getUrlPayment());
        return ordersItemResponse;
    }

    @Override
    public OrdersItemEntity toEntity(OrdersItemModel ordersItemModel) {
        OrdersItemEntity ordersItemEntity = new OrdersItemEntity();
        ordersItemEntity.setOrdersItemId(ordersItemModel.getOrdersItemId());
        ordersItemEntity.setValueTotalUser(ordersItemModel.getValueTotalUser());
        ordersItemEntity.setUrlPayment(ordersItemModel.getUrlPayment());
        return ordersItemEntity;
    }

}
