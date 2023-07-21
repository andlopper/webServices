package com.andlopper.course.resources;

import com.andlopper.course.entities.Product;
import com.andlopper.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/products") //Caminho do recurso
public class ProductResource {

    @Autowired
    private ProductService service;

    //Endpoint para acessar os usuários
    @GetMapping //Responde requisição do tipo GET do HTTP
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Indica que a requisição aceita um "id" na URL
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
