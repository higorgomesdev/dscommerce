package com.devsuperior.dacommerce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dacommerce.DTO.CategoryDTO;
import com.devsuperior.dacommerce.DTO.OrderDTO;
import com.devsuperior.dacommerce.DTO.ProductDTO;
import com.devsuperior.dacommerce.DTO.ProductMinDTO;
import com.devsuperior.dacommerce.entities.Category;
import com.devsuperior.dacommerce.entities.Product;
import com.devsuperior.dacommerce.repositories.OrderRepository;
import com.devsuperior.dacommerce.services.exceptions.DataBaseException;
import com.devsuperior.dacommerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		OrderDTO dto = new OrderDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado")));
		return dto;
	}
	
}
