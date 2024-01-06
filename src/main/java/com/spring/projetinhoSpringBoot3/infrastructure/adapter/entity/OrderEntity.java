package com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_TABLE")
public class OrderEntity {
    @Id
    @Column(name = "order_id",unique = true,nullable = false)
    private long orderId;
    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<OrdersItemEntity> ordersItemEntityList;
    @Column(name = "frete")
    private BigDecimal frete;
    @Column(name = "service_charge")
    private int serviceCharge;
    @Column(name = "discount")
    private BigDecimal discount;
    @NotNull
    @Column(name = "value_total_order")
    private BigDecimal valueTotalOrder;

}
