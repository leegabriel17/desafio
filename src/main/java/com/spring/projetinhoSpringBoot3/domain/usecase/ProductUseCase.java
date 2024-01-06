package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public interface ProductUseCase {
    ProductModel createProduct (ProductRequest userRequest);
}
