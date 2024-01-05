package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repostitory.PurchaseRepository;
import com.platzi.market.persistence.crud.PurchaseEntityCrudRepository;
import com.platzi.market.persistence.entity.PurchaseEntity;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseEntityRepository implements PurchaseRepository {
    @Autowired
    PurchaseEntityCrudRepository crudRepository;
    @Autowired
    PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) crudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return crudRepository.findByIdClientOrderByDateDesc(clientId)
                .map(purchase -> mapper.toPurchases(purchase));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchase);
        purchaseEntity.getProducts().forEach(products -> products.setPurchaseEntity(purchaseEntity));

        return mapper.toPurchase(crudRepository.save(purchaseEntity));
    }
}
