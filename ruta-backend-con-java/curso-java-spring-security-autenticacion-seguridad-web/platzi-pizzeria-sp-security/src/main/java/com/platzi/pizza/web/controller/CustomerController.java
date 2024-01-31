package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.CustomerEntity;
import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.repository.CustomerRepository;
import com.platzi.pizza.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository repository;
    private final OrderService service;

    public CustomerController(CustomerRepository repository, OrderService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(repository.findByPhone(phone));
    }

    @GetMapping("/customer/{id}")
    private ResponseEntity<List<OrderEntity>> getByCustomerOrders(@PathVariable String id) {
        return ResponseEntity.ok(service.getByCustomerOrders(id));
    }
}
