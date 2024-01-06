package com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TABLE")
public class ProductEntity {
    @Id
    @Column(name = "product_id",unique = true,nullable = false)
    private long productId;
    @NotNull
    @Column(name = "product_name",nullable = false)
    private String productName;
    @Column(name = "quantity_product",nullable = false)
    private int quantity;
    @NotNull
    @Column(name = "value_product",nullable = false)
    private BigDecimal valueProduct;
    @ManyToOne
    @JoinColumn(name = "orders_item_id")
    private OrdersItemEntity ordersItemEntity;
}
