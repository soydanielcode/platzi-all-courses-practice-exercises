package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<ProductEntity> findByBarCode(String barCode);
    Optional<List<ProductEntity>> findByInventoryQualityLessThanAndState(int inventoryQuality, boolean state);
}
