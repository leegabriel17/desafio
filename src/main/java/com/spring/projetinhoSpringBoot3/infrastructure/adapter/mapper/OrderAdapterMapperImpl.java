package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrderResponse;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderAdapterMapperImpl implements OrderAdapterMapper {

    @Override
    public OrderEntity toEntity (OrderModel orderModel,List<OrdersItemEntity> ordersItemEntityList){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrdersItemEntityList(ordersItemEntityList);
        orderEntity.setValueTotalOrder(orderModel.getValueTotalOrder());
        orderEntity.setDiscount(orderModel.getDiscount());
        orderEntity.setFrete(orderModel.getFrete());
        orderEntity.setServiceCharge(orderModel.getServiceCharge());
        return orderEntity;
    }
    @Override
    public OrderEntity toEntity (OrderModel orderModel){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderModel.getOrderId());
        orderEntity.setValueTotalOrder(orderModel.getValueTotalOrder());
        orderEntity.setDiscount(orderModel.getDiscount());
        orderEntity.setFrete(orderModel.getFrete());
        orderEntity.setServiceCharge(orderModel.getServiceCharge());
        return orderEntity;
    }

    @Override
    public OrderModel toModel (OrderEntity orderEntity){
        OrderModel orderModel = new OrderModel();
        orderModel.setDiscount(orderEntity.getDiscount());
        orderModel.setFrete(orderEntity.getFrete());
        orderModel.setServiceCharge(orderEntity.getServiceCharge());
        orderModel.setValueTotalOrder(orderEntity.getValueTotalOrder());
        return orderModel;
    }

    @Override
    public OrderModel toModel(OrderRequest orderRequest, List<OrdersItemModel> ordersItemModelList) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderRequest.orderId());
        orderModel.setOrdersItemList(ordersItemModelList);
        orderModel.setDiscount(orderRequest.discount());
        orderModel.setFrete(orderRequest.frete());
        orderModel.setServiceCharge(orderRequest.serviceCharge());
        return orderModel;
    }

    @Override
    public OrderModel toModel(OrderRequest orderRequest){
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderRequest.orderId());
        orderModel.setDiscount(orderRequest.discount());
        orderModel.setFrete(orderRequest.frete());
        orderModel.setServiceCharge(orderRequest.serviceCharge());
        return orderModel;
    }

    @Override
    public OrderResponse toResponse(OrderModel orderModel,List<OrdersItemResponse> ordersItemResponseList){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrdersItemResponseList(ordersItemResponseList);
        orderResponse.setDiscount(orderModel.getDiscount());
        orderResponse.setFrete(orderModel.getFrete());
        orderResponse.setServiceCharge(orderModel.getServiceCharge());
        orderResponse.setValueTotal(orderModel.getValueTotalOrder());
        return orderResponse;
    }
}
