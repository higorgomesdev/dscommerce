package com.devsuperior.dacommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dacommerce.DTO.ProductDTO;
import com.devsuperior.dacommerce.entities.Product;
import com.devsuperior.dacommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		ProductDTO dto = new ProductDTO(repository.findById(id).get());
		return dto;
	}

}
