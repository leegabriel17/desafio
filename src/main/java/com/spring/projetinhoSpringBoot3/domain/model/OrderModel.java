package com.spring.projetinhoSpringBoot3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    private long orderId;
    private List<OrdersItemModel> ordersItemList;
    private BigDecimal frete;
    private int serviceCharge;
    private BigDecimal discount;
    private BigDecimal valueTotalOrder;
}
