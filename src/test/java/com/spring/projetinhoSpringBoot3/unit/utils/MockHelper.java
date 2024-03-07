package com.spring.projetinhoSpringBoot3.unit.utils;

import com.spring.projetinhoSpringBoot3.domain.model.Orders;
import com.spring.projetinhoSpringBoot3.domain.model.Product;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.PaymentRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.PaymentResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MockHelper {

    public static PaymentRequest buildPaymentRequestTeste() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrders(getOrders());
        paymentRequest.setDiscount(BigDecimal.valueOf(20));
        paymentRequest.setDelivery(BigDecimal.valueOf(8));
        paymentRequest.setTotalAmount(BigDecimal.valueOf(50));
        return paymentRequest;
    }

    public static PaymentRequest buildPaymentRequestTesteInvalid() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrders(getOrders());
        paymentRequest.setDiscount(BigDecimal.valueOf(20));
        paymentRequest.setDelivery(BigDecimal.valueOf(8));
        paymentRequest.setTotalAmount(BigDecimal.valueOf(1));
        return paymentRequest;
    }

    public static PaymentResponse buildPaymentResponseTeste(){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setFriendName("amigo1");
        paymentResponse.setProportionalAmount(BigDecimal.valueOf(31.92));
        paymentResponse.setUrlPayment("http://desafio.com/pagamento?token=8785e72e-ce6f-4566-ba4e-c23911c3ae6e&valor=31.92");
        return paymentResponse;
    }

    public static PaymentRequest buildPaymentRequestTesteFalied() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrders(getOrders());
        paymentRequest.setDiscount(BigDecimal.valueOf(20));
        paymentRequest.setDelivery(BigDecimal.valueOf(8));
        return paymentRequest;
    }
    public static List<Orders> getOrders() {
        List<Orders> ordersList = new ArrayList();
        Orders orders = new Orders();
        orders.setProduct(getProduct1());
        orders.setUrlPayment("urlPayment1");
        orders.setName("amigo1");
        orders.setTotalAmountUser(BigDecimal.valueOf(31.92));
        Orders orders1 = new Orders();
        orders1.setProduct(getProduct2());
        orders1.setUrlPayment("urlPayment2");
        orders1.setName("amigo2");
        orders1.setTotalAmountUser(BigDecimal.valueOf(6.08));
        ordersList.add(orders);
        ordersList.add(orders1);
        return ordersList;
    }


    public static List<Product> getProduct1() {
        List<Product> productList =new ArrayList();
        Product product = new Product();
        product.setName("hamburguer");
        product.setAmount(BigDecimal.valueOf(40));
        Product product1 = new Product();
        product1.setName("sobremesa");
        product1.setAmount(BigDecimal.valueOf(2));
        productList.add(product);
        productList.add(product1);
        return productList;
    }
    public static List<Product> getProduct2() {
        List<Product> productList =new ArrayList();
        Product product = new Product();
        product.setName("sanduiche");
        product.setAmount(BigDecimal.valueOf(8));
        productList.add(product);
        return productList;
    }

    public static String builderStringFromJsonFile(final String jsonFileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("./src/test/java/com/spring/projetinhoSpringBoot3/unit/json/" + jsonFileName)));
    }
}
