package com.devsuperior.dacommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dacommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
