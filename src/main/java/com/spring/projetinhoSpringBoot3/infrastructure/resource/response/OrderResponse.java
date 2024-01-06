package com.spring.projetinhoSpringBoot3.infrastructure.resource.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@JsonRootName("orderResponse")
public class OrderResponse {
    private List<OrdersItemResponse> ordersItemResponseList;
    private BigDecimal frete;
    private int serviceCharge;
    private BigDecimal discount;
    private BigDecimal valueTotal;
}
