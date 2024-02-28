package com.spring.projetinhoSpringBoot3.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    @NotNull
    private List<Orders> ordersItemList;
    @NotNull
    private BigDecimal frete = new BigDecimal(0) ;
    @NotNull
    private BigDecimal discount= new BigDecimal(0);
    @NotNull
    private BigDecimal valueTotalOrder= new BigDecimal(0);

}
