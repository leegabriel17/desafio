package com.spring.projetinhoSpringBoot3.domain.gateway;

import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;

public interface ProductDataBaseGateway {
    ProductModel productSave(ProductEntity productEntity);
}