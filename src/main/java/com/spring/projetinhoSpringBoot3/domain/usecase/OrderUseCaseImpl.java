package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.gateway.OrderDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrderAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrdersItemAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrdersItemRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrderResponse;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderUseCaseImpl implements OrderUseCase {

    @Autowired
    private OrderAdapterMapper orderAdapterMapper;

    @Autowired
    private OrdersItemUseCaseImpl ordersItemUseCaseImpl;
    @Autowired
    private OrdersItemUseCase ordersItemUseCase;
    @Autowired
    private OrdersItemAdapterMapper ordersItemAdapterMapper;
    @Autowired
    private OrderDataBaseGateway orderDataBaseGateway;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) throws RuntimeException {
        return processOrder(orderRequest);
    }

    public OrderResponse processOrder(OrderRequest orderRequest) {
        List<OrdersItemRequest> ordersItemRequestList;
        List<OrdersItemModel> ordersItemModelList= new ArrayList<>();
        List<OrdersItemResponse> ordersItemResponseList = new ArrayList<>();
        BigDecimal valueTotalUser;
        BigDecimal valueTotal = BigDecimal.ZERO;
        for(var i=0;i<orderRequest.ordersItemRequestList().length;i++) {
            valueTotalUser = ordersItemUseCaseImpl.calculateTotalValueUser(orderRequest.ordersItemRequestList()[i]);
            valueTotal = valueTotal.add(valueTotalUser);
        }

        OrderModel orderModel = orderAdapterMapper.toModel(orderRequest);
        orderModel.setValueTotalOrder(valueTotal);
        OrderEntity orderEntity = orderDataBaseGateway.orderSave(orderAdapterMapper.toEntity(orderModel));

        for(var i=0;i<orderRequest.ordersItemRequestList().length;i++){
            ordersItemRequestList = Arrays.stream(orderRequest.ordersItemRequestList()).toList();
            valueTotalUser = ordersItemUseCaseImpl.calculateTotalValueUser(ordersItemRequestList.get(i));
            ordersItemModelList.add(ordersItemUseCase.createOrdersItem(orderEntity,ordersItemRequestList.get(i),orderRequest.frete(),orderRequest.serviceCharge(),orderRequest.discount(),valueTotal,valueTotalUser));
        }
        orderModel = orderAdapterMapper.toModel(orderRequest,ordersItemModelList);
        orderModel.setOrdersItemList(ordersItemModelList);
        orderModel.setValueTotalOrder(valueTotal);
        orderDataBaseGateway.orderSave(orderAdapterMapper.toEntity(orderModel));
        for (var i = 0; i<ordersItemModelList.size();i++) {
            ordersItemModelList.get(i).setValueTotalUser(valueTotal);
            ordersItemResponseList.add(ordersItemAdapterMapper.toResponse(ordersItemModelList.get(i)));
        }
        return orderAdapterMapper.toResponse(orderModel,ordersItemResponseList);
    }

}