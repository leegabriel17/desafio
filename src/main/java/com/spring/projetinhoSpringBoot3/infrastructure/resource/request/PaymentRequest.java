package com.spring.projetinhoSpringBoot3.infrastructure.resource.request;

import com.spring.projetinhoSpringBoot3.domain.model.Orders;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PaymentRequest {
     @NotNull
     private List<Orders> orders;
     private BigDecimal delivery;
     private BigDecimal discount;
     @NotNull
     private BigDecimal totalAmount;

     public PaymentRequest() {
     }

     public PaymentRequest(List<Orders> orders, BigDecimal delivery, BigDecimal discount, BigDecimal totalAmount) {
          this.orders = orders;
          this.delivery = delivery;
          this.discount = discount;
          this.totalAmount = totalAmount;
     }
}
