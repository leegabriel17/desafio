package com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository;

import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

}
