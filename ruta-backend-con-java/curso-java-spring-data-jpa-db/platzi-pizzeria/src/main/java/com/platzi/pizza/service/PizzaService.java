package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.repository.PizzaPagAndSortRepository;
import com.platzi.pizza.persistence.repository.PizzaRepository;
import com.platzi.pizza.service.dto.UpdatePizzaDto;
import com.platzi.pizza.service.exception.EmailApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private final PizzaRepository repository;
    private final PizzaPagAndSortRepository pagAndSortRepository;

    @Autowired
    public PizzaService(PizzaRepository repository, PizzaPagAndSortRepository pagAndSortRepository) {
        this.repository = repository;
        this.pagAndSortRepository = pagAndSortRepository;
    }

    public Page<PizzaEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return pagAndSortRepository.findAll(pageRequest);
    }

    public Optional<PizzaEntity> get(int id){
        return repository.findById(id);
    }

    public List<PizzaEntity> getAvailable() {
        return repository.findAllByAvailableTrueOrderByPrice();
    }

    public Page<PizzaEntity> getAvailablePageSort(int page, int elements, String properties, String direction){
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), properties);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        return pagAndSortRepository.findByAvailableTrue(pageRequest);
    }

    public PizzaEntity getName(String name) {
        return repository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElse(null);
    }

    public List<PizzaEntity> getWith(String ingredient) {
        return repository.findAllByAvailableTrueAndDescriptionContainsIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithout(String ingredient) {
        return repository.findAllByAvailableTrueAndDescriptionNotContainsIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapest(double price){
        return repository.findTop4ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity save(PizzaEntity pizzaEntity){
        return repository.save(pizzaEntity);
    }

    @Transactional
    public void updatePrice(UpdatePizzaDto pizzaDto) {
        repository.updatePrice(pizzaDto);
        this.sendEmail();
    }

    @Transactional(noRollbackFor = EmailApiException.class, propagation = Propagation.REQUIRED)
    public void sendEmail() {
        throw new EmailApiException();
    }

    public Boolean existId(int id){
        return repository.existsById(id);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
