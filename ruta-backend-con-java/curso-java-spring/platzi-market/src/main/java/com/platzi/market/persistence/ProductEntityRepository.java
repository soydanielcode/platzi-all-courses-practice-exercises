package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductEntityRepository {
    private ProductCrudRepository productCrudRepository;

    public List<ProductEntity> getAll(){
        return (List<ProductEntity>) productCrudRepository.findAll();
    }

    public List<ProductEntity> getByCategory(int idCategory){
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<ProductEntity> getProductByBarCode(String barcode){
        return productCrudRepository.findByBarCode(barcode);
    }

    public Optional<List<ProductEntity>>getShortage(int quality){
        return productCrudRepository.findByInventoryQualityLessThanAndState(quality,true);
    }

    public Optional<ProductEntity> getProduct(int id){
        return productCrudRepository.findById(id);
    }

    public ProductEntity save(ProductEntity productEntity){
        return productCrudRepository.save(productEntity);
    }

    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }

}
