package com.andlopper.course.services;

import com.andlopper.course.entities.Order;
import com.andlopper.course.entities.User;
import com.andlopper.course.repositories.OrderRepository;
import com.andlopper.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
