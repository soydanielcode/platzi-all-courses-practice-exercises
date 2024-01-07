package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    PurchaseService service;

    @GetMapping("/all")
    private ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    private ResponseEntity<List<Purchase>> getByClient(@PathVariable("clientId") String clientId) {
        return service.getByClient((clientId))
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    private ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(service.save(purchase), HttpStatus.CREATED);
    }
}
