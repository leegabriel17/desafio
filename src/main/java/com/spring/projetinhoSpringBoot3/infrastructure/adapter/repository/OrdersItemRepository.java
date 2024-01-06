package com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository;

import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItemEntity,Long> {

}
