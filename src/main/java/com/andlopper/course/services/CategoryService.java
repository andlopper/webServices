package com.andlopper.course.services;

import com.andlopper.course.entities.Category;
import com.andlopper.course.entities.User;
import com.andlopper.course.repositories.CategoryRepository;
import com.andlopper.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registra classe como serviço do Spring
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
