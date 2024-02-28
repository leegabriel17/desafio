package com.spring.projetinhoSpringBoot3.domain.usecase;


import com.spring.projetinhoSpringBoot3.domain.model.Orders;
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
public class PaymentService{
    public List<PaymentResponse> processPayment(PaymentRequest paymentRequest) throws BadRequestException {
        List<PaymentResponse> paymentResponseList = new ArrayList<>();
        try {
            BigDecimal delivery = paymentRequest.getDelivery();
            BigDecimal discount = paymentRequest.getDiscount();
            BigDecimal totalAmount = paymentRequest.getTotalAmount();
            if(checkAmount(paymentRequest)){
                throw new BadRequestException("valores inválidos");
            }
            for (var i = 0; i < paymentRequest.getOrders().size(); i++) {
                PaymentResponse paymentResponse = new PaymentResponse();
                BigDecimal amountIndividual = calculateIndividualAmount(paymentRequest.getOrders().get(i), delivery, discount, totalAmount);
                String tokenUnic = UUID.randomUUID().toString();
                String urlPayment = getLinkPayment(tokenUnic, amountIndividual);
                paymentResponse.setFriendName(paymentRequest.getOrders().get(i).getName());
                paymentResponse.setProportionalAmount(amountIndividual);
                paymentResponse.setUrlPayment(urlPayment);
                paymentResponseList.add(paymentResponse);
            }
        }catch (RuntimeException e){
            throw new BadRequestException("Erro ao processar o pagamento: " + e.getMessage());
        }
        return paymentResponseList;
    }

    private boolean checkAmount(PaymentRequest paymentRequest) {
        BigDecimal totalIndividual = BigDecimal.ZERO;
        for (var i = 0; i < paymentRequest.getOrders().size(); i++) {

            for (var j = 0; j < paymentRequest.getOrders().get(i).getProduct().size(); j++) {
                totalIndividual = totalIndividual.add(paymentRequest.getOrders().get(i).getProduct().get(j).getAmount());
            }
        }
        if(totalIndividual.equals(paymentRequest.getTotalAmount())){
            return false;
        }
        return true;
    }


    private BigDecimal calculateIndividualAmount(Orders ordersListDto, BigDecimal delivery, BigDecimal discount, BigDecimal totalAmount) {
        BigDecimal totalIndividual = BigDecimal.ZERO;
        for (var i = 0; i < ordersListDto.getProduct().size(); i++) {
            totalIndividual = totalIndividual.add(ordersListDto.getProduct().get(i).getAmount());
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