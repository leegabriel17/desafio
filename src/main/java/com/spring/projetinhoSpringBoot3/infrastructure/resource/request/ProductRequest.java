package com.spring.projetinhoSpringBoot3.infrastructure.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record ProductRequest (
    @NotNull
    @JsonProperty(value = "productId")
    long productId,
    @NotNull
    @JsonProperty(value = "productName")
    String productName,
    @NotNull
    @JsonProperty(value = "quantity")
    int quantity,
    @NotNull
    @JsonProperty(value = "valueProduct")
    BigDecimal valueProduct
    ){}
