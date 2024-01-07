package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
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
    @Operation(summary = "Get all purchases")
    @ApiResponse(responseCode = "200", description = "OK")
    private ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get purchases by client Id")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/client/{clientId}")
    private ResponseEntity<List<Purchase>> getByClient(@PathVariable("clientId") String clientId) {
        return service.getByClient((clientId))
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "To Save a purchase")
    @ApiResponse(responseCode = "200", description = "Created")
    @PostMapping("/save")
    private ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(service.save(purchase), HttpStatus.CREATED);
    }
}
