package com.spring.projetinhoSpringBoot3.infrastructure.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest (
    @JsonProperty(value = "orderId")
    long orderId,
    @JsonProperty(value = "ordersItemRequestList")
    OrdersItemRequest[] ordersItemRequestList,
    @JsonProperty(value = "frete")
    BigDecimal frete,
    @JsonProperty(value = "serviceCharge")
    int serviceCharge,
    @JsonProperty(value = "discount")
    BigDecimal discount
){
}
