package com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "ORDERS_ITEM_TABLE")
public class OrdersItemEntity {
    @Id
    @Column(name = "orders_item_id",unique = true,nullable = false)
    private long ordersItemId;
    @OneToMany(mappedBy = "ordersItemEntity", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @NotNull
    @Column(name = "value_total_user",nullable = false)
    private BigDecimal valueTotalUser;
    @NotNull
    @Column(name = "url_payment",nullable = false)
    private String urlPayment;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
