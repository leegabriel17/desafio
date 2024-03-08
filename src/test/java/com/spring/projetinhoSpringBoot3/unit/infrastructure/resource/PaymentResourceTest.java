package com.spring.projetinhoSpringBoot3.unit.infrastructure.resource;

import com.spring.projetinhoSpringBoot3.domain.usecase.PaymentService;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.PaymentResource;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.PaymentRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.PaymentResponse;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static com.spring.projetinhoSpringBoot3.unit.utils.MockHelper.buildPaymentRequestTeste;
import static com.spring.projetinhoSpringBoot3.unit.utils.MockHelper.builderStringFromJsonFile;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.testng.Assert.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest(classes = {PaymentResource.class})
public class PaymentResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PaymentService paymentService;

    @Autowired
    private PaymentResource paymentResource;

    @Test
    public void testProcessPaymentResourceSuccess() throws Exception {

        PaymentRequest paymentRequest = new PaymentRequest(buildPaymentRequestTeste());
        List<PaymentResponse> paymentResponseList = new ArrayList<>();
        when(paymentService.processPayment(paymentRequest)).thenReturn(paymentResponseList);
        ResponseEntity<List<PaymentResponse>> responseEntity = paymentResource.calculatePayment(paymentRequest);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(paymentService, times(1)).processPayment(paymentRequest);

    }
    @Test
    public void testProcessPaymentResourceFalied() throws Exception {
        when(paymentService.processPayment(any())).thenThrow(new BadRequestException());
        mockMvc.perform(post("/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(builderStringFromJsonFile("PaymentSuccess.json")))
                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());

    }
}
