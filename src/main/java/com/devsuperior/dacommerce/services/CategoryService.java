package com.devsuperior.dacommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dacommerce.DTO.CategoryDTO;
import com.devsuperior.dacommerce.entities.Category;
import com.devsuperior.dacommerce.repositories.CategoryRepository;



@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll () {
		List<Category> list = repository.findAll();
	    return list.stream().map(p-> new CategoryDTO(p)).toList();
	}
	
}
