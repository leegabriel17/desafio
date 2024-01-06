package com.spring.projetinhoSpringBoot3.infrastructure.adapter.repository;

import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}