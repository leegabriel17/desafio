package com.spring.projetinhoSpringBoot3.infrastructure.resource.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Setter
@JsonSerialize
public class ProductResponse {
    private String productName;
    private int quantity;
    private BigDecimal valueProduct;
}
