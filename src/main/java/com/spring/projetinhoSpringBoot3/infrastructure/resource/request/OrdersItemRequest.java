package com.spring.projetinhoSpringBoot3.infrastructure.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public record OrdersItemRequest (
     @NotNull
     @JsonProperty(value = "ordersItemId")
     long ordersItemId,
     @Valid
     @JsonProperty(value = "productModel")
     ProductModel[] productModel,
     @JsonProperty(value = "userModel")
     UserModel userModel
){}
