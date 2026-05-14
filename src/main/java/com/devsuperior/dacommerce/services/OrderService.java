package com.devsuperior.dacommerce.services;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dacommerce.DTO.OrderDTO;
import com.devsuperior.dacommerce.DTO.OrderItemDTO;
import com.devsuperior.dacommerce.entities.Order;
import com.devsuperior.dacommerce.entities.OrderItem;
import com.devsuperior.dacommerce.entities.Product;
import com.devsuperior.dacommerce.entities.User;
import com.devsuperior.dacommerce.enums.OrderStatus;
import com.devsuperior.dacommerce.repositories.OrderItemRepository;
import com.devsuperior.dacommerce.repositories.OrderRepository;
import com.devsuperior.dacommerce.repositories.ProductRepository;
import com.devsuperior.dacommerce.services.exceptions.ForbiddenException;
import com.devsuperior.dacommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		OrderDTO dto = new OrderDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado")));
		authService.validateselfOrAdmin(dto.getClient().getId());
		return dto;
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		order.setClient(userService.authenticated());
		for(OrderItemDTO itemDTO : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDTO.getProductId());
			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setProduct(product);
			item.setQuantity(itemDTO.getQuantity());
			item.setPrice(product.getPrice());
			order.getItems().add(item);
		}
		repository.save(order);
		orderItemRepository.saveAll(order.getItems());
		return new OrderDTO(order);
		
	}
	
}
