package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.gateway.ProductDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.ProductAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUseCaseImpl implements ProductUseCase{

    @Autowired
    private ProductAdapterMapper productAdapterMapper;

    @Autowired
    private ProductDataBaseGateway productDataBaseGateway;

    @Override
    public ProductModel createProduct(ProductRequest productRequest) {
        final ProductModel productModel = productAdapterMapper.toModel(productRequest);
        return productDataBaseGateway.productSave(productAdapterMapper.toEntity(productModel));
    }


}
