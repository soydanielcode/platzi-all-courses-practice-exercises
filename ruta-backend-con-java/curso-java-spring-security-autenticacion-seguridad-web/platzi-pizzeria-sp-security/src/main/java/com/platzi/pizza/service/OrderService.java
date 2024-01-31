package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.proyections.OrderSummary;
import com.platzi.pizza.persistence.repository.OrderRepository;
import com.platzi.pizza.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final String DELIVERY = "D";
    private final String CARRYOUT = "C";
    private final String ON_SITE = "S";

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderEntity> getAll() {
        return repository.findAll();
    }

    public List<OrderEntity> getToday() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return repository.findAllByDateAfter(today);
    }

    public List<OrderEntity> getOutsideOrders(){
        List<String>methods = Arrays.asList(DELIVERY, CARRYOUT);
        return repository.findAllByMethodInOrderByDate(methods);
    }

    @Secured("ROLE_ADMIN")
    public List<OrderEntity> getByCustomerOrders(String id){
        return repository.findCustomerByOrders(id);
    }

    public OrderSummary getSummary(int idOrder){
        return repository.findSummary(idOrder);
    }

    @Transactional
    public boolean saveRandomOrder(RandomOrderDto randomOrderDto) {
        return repository.saveRandomOrder(randomOrderDto.getIdCustomer(), randomOrderDto.getMethod());
    }
}
