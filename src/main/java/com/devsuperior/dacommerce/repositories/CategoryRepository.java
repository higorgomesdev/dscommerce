package com.devsuperior.dacommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dacommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
