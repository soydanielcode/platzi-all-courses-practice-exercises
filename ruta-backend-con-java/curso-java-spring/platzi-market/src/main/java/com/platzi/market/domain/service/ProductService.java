package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repostitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public List<Product> getByCategory(int idCategory){
        return productRepository.getByCategory(idCategory);
    }

    public Optional<Product> getProductByBarcode(String barcode){
        return productRepository.getProductByBarcode(barcode);
    }

    public Optional<List<Product>> getShortage(int quality) {
        return productRepository.getShortage(quality);
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int id) {
        return getProduct(id).map(product -> {
            productRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
