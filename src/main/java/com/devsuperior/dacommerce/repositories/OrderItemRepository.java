package com.devsuperior.dacommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dacommerce.entities.OrderItem;
import com.devsuperior.dacommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
}
