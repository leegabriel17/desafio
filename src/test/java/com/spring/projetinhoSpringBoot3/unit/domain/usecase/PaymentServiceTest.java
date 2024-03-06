package com.spring.projetinhoSpringBoot3.unit.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.usecase.PaymentService;
import com.spring.projetinhoSpringBoot3.infrastructure.configuration.ExceptionHandlerPayment;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.PaymentRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.PaymentResponse;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.spring.projetinhoSpringBoot3.unit.utils.MockHelper.buildPaymentRequestTeste;
import static com.spring.projetinhoSpringBoot3.unit.utils.MockHelper.buildPaymentRequestTesteInvalid;
import static com.spring.projetinhoSpringBoot3.unit.utils.MockHelper.buildPaymentResponseTeste;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {PaymentService.class})
public class PaymentServiceTest {


    @Autowired
    private PaymentService paymentService;

    @Test
    public void testProcessPaymentController() throws BadRequestException {

        PaymentRequest paymentRequest = buildPaymentRequestTeste();
        List<PaymentResponse> paymentResponseListfail = null;
        List<PaymentResponse> paymentResponseList = paymentService.processPayment(paymentRequest);
        Assertions.assertNotEquals(paymentResponseList,paymentResponseListfail);
        Assertions.assertFalse(paymentResponseList.isEmpty());
        Assertions.assertDoesNotThrow(() -> paymentResponseList.get(1));
       }

    @Test
    public void testProcessPaymentTestFalied() throws BadRequestException {

        PaymentRequest paymentRequest = buildPaymentRequestTesteInvalid();
        Assertions.assertThrows(BadRequestException.class, () -> {
            paymentService.processPayment(paymentRequest);
        });

    }
}
