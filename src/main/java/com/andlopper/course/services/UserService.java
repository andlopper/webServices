package com.andlopper.course.services;

import com.andlopper.course.entities.User;
import com.andlopper.course.repositories.UserRepository;
import com.andlopper.course.services.exceptions.DatabaseException;
import com.andlopper.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registra classe como serviço do Spring
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //Tenta dar o GET, se não lança exceção
    }

    public User insert(User obj){
        return repository.save(obj); //Salvar novo usuário
    }

    public void delete(Long id){
        try {
            repository.deleteById(id); //Deleta usuário
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id); //NÃO FUNCIONANDO
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
