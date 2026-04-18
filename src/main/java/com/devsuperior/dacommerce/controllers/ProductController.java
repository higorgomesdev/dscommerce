package com.devsuperior.dacommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dacommerce.DTO.ProductDTO;
import com.devsuperior.dacommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ProductDTO findByID(@PathVariable Long id) {
		return service.findById(id);
	
	}
	
	@GetMapping
	public Page<ProductDTO> findAll(Pageable pegeable) {
		return service.findAll(pegeable);
	
	}

}
