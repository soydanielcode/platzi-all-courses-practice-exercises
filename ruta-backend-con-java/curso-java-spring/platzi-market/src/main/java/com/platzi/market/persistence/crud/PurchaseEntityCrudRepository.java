package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseEntityCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByIdClientOrderByDateDesc(String idClient);
}
