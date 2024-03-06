package com.spring.projetinhoSpringBoot3.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Orders {
    private List<Product> product;
    private String name;
    @NotNull
    private BigDecimal totalAmountUser;
    private String urlPayment;
}
