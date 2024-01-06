package com.spring.projetinhoSpringBoot3.infrastructure.resource;

import com.spring.projetinhoSpringBoot3.domain.usecase.OrderUseCase;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
public class OrderResource {

    @Autowired
    private OrderUseCase orderUseCase;

    @GetMapping("/order")
    @ResponseBody
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) throws RuntimeException {
        return ResponseEntity.ok().body(orderUseCase.createOrder(orderRequest));
    }

}
