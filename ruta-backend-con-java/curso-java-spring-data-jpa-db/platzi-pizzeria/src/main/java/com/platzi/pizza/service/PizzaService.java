package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private final PizzaRepository repository;

    @Autowired
    public PizzaService(PizzaRepository repository) {
        this.repository = repository;
    }

    public List<PizzaEntity> getAll() {
        return repository.findAll();
    }

    public Optional<PizzaEntity> get(int id){
        return repository.findById(id);
    }

    public List<PizzaEntity> getAvailable() {
        return repository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getName(String name) {
        return repository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getWith(String ingredient) {
        return repository.findAllByAvailableTrueAndDescriptionContainsIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithout(String ingredient) {
        return repository.findAllByAvailableTrueAndDescriptionNotContainsIgnoreCase(ingredient);
    }

    public PizzaEntity save(PizzaEntity pizzaEntity){
        return repository.save(pizzaEntity);
    }

    public Boolean existId(int id){
        return repository.existsById(id);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
