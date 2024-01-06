package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductAdapterMapper {
    ProductEntity toEntity (ProductModel productModel);

    ProductModel toModel (ProductEntity productEntity);

    List<ProductModel> toModel (List<ProductEntity> productEntity);

    ProductModel toModel(ProductRequest productRequest);

}
