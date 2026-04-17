package com.devsuperior.dacommerce.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dacommerce.DTO.ProductDTO;
import com.devsuperior.dacommerce.entities.Product;
import com.devsuperior.dacommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ProductDTO findByID(@PathVariable Long id) {
		ProductDTO dto = service.findById(id);
		return dto;
	}

}
