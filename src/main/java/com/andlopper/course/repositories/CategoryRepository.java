package com.andlopper.course.repositories;

import com.andlopper.course.entities.Category;
import com.andlopper.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
