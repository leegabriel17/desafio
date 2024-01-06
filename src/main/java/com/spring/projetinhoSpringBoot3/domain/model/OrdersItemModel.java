package com.spring.projetinhoSpringBoot3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersItemModel {
    private long ordersItemId;
    private List<ProductModel> productModelList;
    private UserModel userModel;
    private BigDecimal valueTotalUser;
    private String urlPayment;
}
