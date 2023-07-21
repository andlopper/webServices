package com.andlopper.course.resources;

import com.andlopper.course.entities.Category;
import com.andlopper.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/categories") //Caminho do recurso
public class CategoryResource {

    @Autowired
    private CategoryService service;

    //Endpoint para acessar os usuários
    @GetMapping //Responde requisição do tipo GET do HTTP
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Indica que a requisição aceita um "id" na URL
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
