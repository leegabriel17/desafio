package com.spring.projetinhoSpringBoot3.infrastructure.resource.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@JsonSerialize
public class OrdersItemResponse {
    private List<ProductResponse> productResponseList;
    private UserResponse userResponse;
    private BigDecimal amount;
    private String urlPagamento;
}
