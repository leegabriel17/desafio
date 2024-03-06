package com.spring.projetinhoSpringBoot3.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    public String name;
    @NotNull
    public BigDecimal amount;
}
