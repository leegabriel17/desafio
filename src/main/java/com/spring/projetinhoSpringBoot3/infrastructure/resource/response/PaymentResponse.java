package com.spring.projetinhoSpringBoot3.infrastructure.resource.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PaymentResponse {
    String friendName;
    BigDecimal proportionalAmount;
    String urlPayment;
}
