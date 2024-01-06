package com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class UserEntity {
    @Id
    @Column(name = "user_id",unique = true,nullable = false)
    private long userId;
    @Column(name = "user_name",nullable = false)
    private String userName;
    @NotNull
    @CPF
    @Column(name = "cpf",nullable = false,unique = true)
    private String cpf;
    @Email
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "user_password",nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "orders_item_id")
    private OrdersItemEntity ordersItemEntity;
}
