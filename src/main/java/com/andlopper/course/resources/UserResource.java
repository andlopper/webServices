package com.andlopper.course.resources;

import com.andlopper.course.entities.User;
import com.andlopper.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/users") //Caminho do recurso
public class UserResource {

    @Autowired
    private UserService service;

    //Endpoint para acessar os usuários
    @GetMapping //Responde requisição do tipo GET do HTTP
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Indica que a requisição aceita um "id" na URL
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping //Método POST HTTP
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        //URI - Identificador do recurso
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //Endereço do novo recurso inserido
        return ResponseEntity.created(uri).body(obj); //201 - Novo recurso (Created)
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); //204 - Resposta vazia
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
