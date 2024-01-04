package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repostitory.ProductRepository;
import com.platzi.market.persistence.crud.ProductEntityCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductEntityRepository implements ProductRepository {
    @Autowired
    private ProductEntityCrudRepository productEntityCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(){
        return productMapper.toProducts((List<ProductEntity>) productEntityCrudRepository.findAll());
    }

    @Override
    public List<Product> getByCategory(int idCategory){
        return productMapper.toProducts(productEntityCrudRepository.findByIdCategoryOrderByNameAsc(idCategory));
    }

    @Override
    public Optional<Product> getProductByBarcode(String barcode) {
        return productEntityCrudRepository.findByBarCode(barcode).map(productEntity -> productMapper.toProduct(productEntity));
    }

    @Override
    public Optional<List<Product>>getShortage(int quality){
        Optional<List<Product>> productEntities = productEntityCrudRepository.
                findByInventoryQualityLessThanAndState(quality, true).map(pEntity -> productMapper.toProducts(pEntity));
        return productEntities;
    }

    @Override
    public Optional<Product> getProduct(int id){
        return productEntityCrudRepository.findById(id).map(productEntity -> productMapper.toProduct(productEntity));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        return productMapper.toProduct(productEntityCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int idProduct){
        productEntityCrudRepository.deleteById(idProduct);
    }

}
