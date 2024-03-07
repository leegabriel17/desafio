package com.spring.projetinhoSpringBoot3.domain.usecase;


import com.spring.projetinhoSpringBoot3.domain.model.Orders;
import com.spring.projetinhoSpringBoot3.domain.model.Product;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.PaymentRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.PaymentResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {
    public List<PaymentResponse> processPayment(PaymentRequest paymentRequest) throws BadRequestException {
        List<PaymentResponse> paymentResponseList = new ArrayList<>();
        try {
            BigDecimal delivery = paymentRequest.getDelivery();
            BigDecimal discount = paymentRequest.getDiscount();
            BigDecimal totalAmount = paymentRequest.getTotalAmount();
            checkAmount(paymentRequest);
            for (Orders ordersList : paymentRequest.getOrders()) {
                BigDecimal amountIndividual = calculateIndividualAmount(ordersList, delivery, discount, totalAmount);
                String tokenUnic = UUID.randomUUID().toString();
                String urlPayment = getLinkPayment(tokenUnic, amountIndividual);
                PaymentResponse paymentResponse = new PaymentResponse(ordersList.getName(),amountIndividual,urlPayment);
                paymentResponseList.add(paymentResponse);
            }
        }catch (RuntimeException e) {
            throw new BadRequestException("Erro ao processar o pagamento: " + e.getMessage());
        }
        return paymentResponseList;
    }

    private void checkAmount(PaymentRequest paymentRequest) throws BadRequestException {
        BigDecimal totalIndividual = BigDecimal.ZERO;
        for (Orders ordersList : paymentRequest.getOrders()) {

            for (Product productlist : ordersList.getProduct()) {
                totalIndividual = totalIndividual.add(productlist.getAmount());
            }
        }
        if (!totalIndividual.equals(paymentRequest.getTotalAmount())) {
            throw new BadRequestException("valores informados não estão corretos");
        }
    }

    private BigDecimal calculateIndividualAmount(Orders ordersListDto, BigDecimal delivery, BigDecimal discount, BigDecimal totalAmount) {
        BigDecimal totalIndividual = BigDecimal.ZERO;
        for (Product ordersLitsDto : ordersListDto.getProduct()) {
            totalIndividual = totalIndividual.add(ordersLitsDto.getAmount());
        }
        BigDecimal porcent = totalIndividual.divide(totalAmount, 2, RoundingMode.HALF_UP);
        BigDecimal partDelivery = delivery.multiply(porcent);
        BigDecimal partDiscount = discount.multiply(porcent);
        return  totalIndividual.add(partDelivery).subtract(partDiscount);

    }

    private static String getLinkPayment(String token, BigDecimal valor) {
        return "http://desafio.com/pagamento?token=" + token + "&valor=" + valor;
    }

}