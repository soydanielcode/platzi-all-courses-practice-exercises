package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    private List<Product> getAll(){
        return productService.getAll();
    }

    private List<Product> getByCategory(int id) {
        return productService.getByCategory(id);
    }

    private Optional<Product> getProductByBarcode(String barcode) {
        return productService.getProductByBarcode(barcode);
    }

    private Optional<List<Product>> getShortage(int quality) {
        return productService.getShortage(quality);
    }

    private Optional<Product> getProduct(int id) {
        return productService.getProduct(id);
    }

    private Product save(Product product) {
        return productService.save(product);
    }

    private boolean delete(int id) {
        return productService.delete(id);
    }
}
