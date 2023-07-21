package com.andlopper.course.resources;

import com.andlopper.course.entities.Order;
import com.andlopper.course.entities.User;
import com.andlopper.course.services.OrderService;
import com.andlopper.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/orders") //Caminho do recurso
public class OrderResource {
    @Autowired
    private OrderService service;

    //Endpoint para acessar os pedidos
    @GetMapping //Responde requisição do tipo GET do HTTP
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Indica que a requisição aceita um "id" na URL
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
