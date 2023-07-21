package com.andlopper.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity //Instruindo JPA como converter os objetos para modelo relacional
@Table(name = "tb_category") //Renomeando o nome "user" para evitar conflito no H2
public class Category implements Serializable {
    @Id //Indicando que "Id" é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;
    private String name;
    @JsonIgnore //Evitar loop na consulta
    @ManyToMany(mappedBy = "categories") //Atributo mapeado por este nome da classe Product
    private Set<Product> products = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category user = (Category) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
