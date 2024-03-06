package com.spring.projetinhoSpringBoot3.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PaymentDto {
    @NotNull
    private List<Orders> ordersItemList;
    @NotNull
    private BigDecimal delivery = new BigDecimal(0) ;
    @NotNull
    private BigDecimal discount= new BigDecimal(0);
    @NotNull
    private BigDecimal valueTotalOrder= new BigDecimal(0);

}
