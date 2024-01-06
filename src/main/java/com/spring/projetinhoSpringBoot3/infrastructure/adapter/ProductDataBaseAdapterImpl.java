package com.spring.projetinhoSpringBoot3.infrastructure.adapter;

import com.spring.projetinhoSpringBoot3.domain.gateway.ProductDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.ProductAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDataBaseAdapterImpl implements ProductDataBaseGateway {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAdapterMapper productAdapterMapper;

    @Override
    public ProductModel productSave(ProductEntity productEntity) {
        return productAdapterMapper.toModel(productRepository.save(productEntity));
    }
}
