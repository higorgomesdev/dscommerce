package com.devsuperior.dacommerce.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dacommerce.entities.Order;
import com.devsuperior.dacommerce.entities.Product;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
