package com.devsuperior.dacommerce.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dacommerce.DTO.OrderDTO;
import com.devsuperior.dacommerce.DTO.ProductDTO;
import com.devsuperior.dacommerce.DTO.ProductMinDTO;
import com.devsuperior.dacommerce.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findByID(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
}
