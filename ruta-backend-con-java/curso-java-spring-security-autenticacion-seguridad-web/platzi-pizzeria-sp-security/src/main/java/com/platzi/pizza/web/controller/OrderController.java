package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.proyections.OrderSummary;
import com.platzi.pizza.service.OrderService;
import com.platzi.pizza.service.dto.RandomOrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    private ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/today")
    private ResponseEntity<List<OrderEntity>> getToday(){
        return ResponseEntity.ok(service.getToday());
    }

    @GetMapping("/outside")
    private ResponseEntity<List<OrderEntity>> getOutsideOrders(){
        return ResponseEntity.ok(service.getOutsideOrders());
    }

    @GetMapping("/customer/{id}")
    private ResponseEntity<List<OrderEntity>> getByCustomerOrders(@PathVariable String id) {
        return ResponseEntity.ok(service.getByCustomerOrders(id));
    }

    @GetMapping("/summary/{orderId}")
    private ResponseEntity<OrderSummary> getSummary(@PathVariable int orderId) {
        return ResponseEntity.ok(service.getSummary(orderId));
    }

    @PostMapping("/random")
    public  ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto orderDto) {
        return ResponseEntity.ok(service.saveRandomOrder(orderDto));
    }

}
