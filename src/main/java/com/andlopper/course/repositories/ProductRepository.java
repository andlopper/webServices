package com.andlopper.course.repositories;

import com.andlopper.course.entities.Category;
import com.andlopper.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
