package com.andlopper.course.repositories;

import com.andlopper.course.entities.OrderItem;
import com.andlopper.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
