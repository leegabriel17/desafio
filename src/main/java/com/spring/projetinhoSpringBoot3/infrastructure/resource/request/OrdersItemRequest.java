package com.spring.projetinhoSpringBoot3.infrastructure.resource.request;

import com.spring.projetinhoSpringBoot3.domain.model.Product;

import java.util.List;

public class OrdersItemRequest {
    private List<Product> product;
    private String  userName;
    public OrdersItemRequest() {
    }

    public OrdersItemRequest(List<Product> product, String userName) {
        this.product = product;
        this.userName = userName;
    }
}
