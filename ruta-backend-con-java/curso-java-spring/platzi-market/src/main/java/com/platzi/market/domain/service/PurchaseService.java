package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repostitory.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository repository;

    public List<Purchase> getAll(){
        return repository.getAll();
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return repository.getByClient(clientId);
    }
    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }
}
