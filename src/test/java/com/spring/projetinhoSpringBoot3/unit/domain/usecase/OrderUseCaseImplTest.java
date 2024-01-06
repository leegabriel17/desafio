package com.spring.projetinhoSpringBoot3.unit.domain.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.projetinhoSpringBoot3.domain.gateway.OrderDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.usecase.OrderUseCaseImpl;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrderResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.io.IOException;
import static com.spring.projetinhoSpringBoot3.unit.utils.MockHelper.buildStringFromJsonFile;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OrderUseCaseImplTest {
/*
    @MockBean
    private OrderDataBaseGateway orderDataBaseGateway;

    @InjectMocks
    private OrderUseCaseImpl orderUseCase;

    @Test
    public void testProcessOrder() throws IOException {
        final var json = buildStringFromJsonFile("OrderCreateSuccess.json");
        ObjectMapper objectMapper = new ObjectMapper();
        OrderRequest orderRequest = objectMapper.readValue(json,OrderRequest.class);

        when(orderDataBaseGateway.orderSave(any(OrderEntity.class))).thenReturn(createTestOrderEntity());
        OrderResponse result = orderUseCase.processOrder(orderRequest);
        assertNotNull(result);
    }
  */

}
