package com.spring.projetinhoSpringBoot3.infrastructure.resource;

import com.spring.projetinhoSpringBoot3.domain.usecase.PaymentService;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.PaymentRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.PaymentResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class PaymentResource {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<List<PaymentResponse>> calculatePayment(@RequestBody PaymentRequest paymentRequest) throws BadRequestException {
        List<PaymentResponse> paymentResponseList = paymentService.processPayment(paymentRequest);
        return new ResponseEntity<>( paymentResponseList, HttpStatus.OK);
    }

}
