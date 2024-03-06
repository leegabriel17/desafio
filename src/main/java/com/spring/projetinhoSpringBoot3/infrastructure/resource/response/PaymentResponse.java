package com.spring.projetinhoSpringBoot3.infrastructure.resource.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PaymentResponse {
    String friendName;
    BigDecimal proportionalAmount;
    String urlPayment;
}
