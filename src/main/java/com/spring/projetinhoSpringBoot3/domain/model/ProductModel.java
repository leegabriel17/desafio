package com.spring.projetinhoSpringBoot3.domain.model;

import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    public long productId;
    public String productName;
    public int quantity;
    public BigDecimal valueProduct;

}
