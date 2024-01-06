package com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper;

import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductAdapterMapperImpl implements ProductAdapterMapper{

    @Override
    public ProductEntity toEntity (ProductModel productModel){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productModel.getProductId());
        productEntity.setProductName(productModel.getProductName());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setValueProduct(productModel.getValueProduct());
        return productEntity;
    }

    @Override
    public ProductModel toModel (ProductEntity productEntity){
        ProductModel productModel = new ProductModel();
        productModel.setProductId(productEntity.getProductId());
        productModel.setProductName(productEntity.getProductName());
        productModel.setQuantity(productEntity.getQuantity());
        productModel.setValueProduct(productEntity.getValueProduct());
        return productModel;
    }

    @Override
    public List<ProductModel> toModel(List<ProductEntity> productEntity) {
        List<ProductModel> productModelList = new ArrayList<>();
        ProductModel productModel = new ProductModel();
        for(var i =0; i<productEntity.size();i++){
            productModel.setProductId(productEntity.get(i).getProductId());
            productModel.setProductName(productEntity.get(i).getProductName());
            productModel.setValueProduct(productEntity.get(i).getValueProduct());
            productModel.setQuantity(productEntity.get(i).getQuantity());
            productModelList.add(productModel);
        }
        return productModelList;
    }

    @Override
    public ProductModel toModel(ProductRequest productRequest){
        ProductModel productModel = new ProductModel();
        productModel.setProductId(productRequest.productId());
        productModel.setProductName(productRequest.productName());
        productModel.setQuantity(productRequest.quantity());
        productModel.setValueProduct(productRequest.valueProduct());
        return productModel;
    }

}
