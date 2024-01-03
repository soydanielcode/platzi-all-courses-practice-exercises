package com.platzi.market.domain.repostitory;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    List<Product> getByCategory(int idCategory);
    Optional<Product> getProductByBarcode(String barcode);
    Optional<List<Product>> getShortage(int quality);
    Optional<Product> getProduct(int id);
    Product save(Product product);
    void delete(int id);
}
