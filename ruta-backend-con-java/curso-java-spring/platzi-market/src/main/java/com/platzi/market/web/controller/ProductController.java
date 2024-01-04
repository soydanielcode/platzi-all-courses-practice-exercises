package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/category/{id}")
    private List<Product> getByCategory(@PathVariable("id") int id) {
        return productService.getByCategory(id);
    }

    @GetMapping("/barcode/{barcode}")
    private Optional<Product> getProductByBarcode(@PathVariable("barcode") String barcode) {
        return productService.getProductByBarcode(barcode);
    }

    @GetMapping("/shortage/{quality}")
    private Optional<List<Product>> getShortage(@PathVariable("quality") int quality) {
        return productService.getShortage(quality);
    }

    @GetMapping("/{id}")
    private Optional<Product> getProduct(@PathVariable("id") int id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    private Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    private boolean delete(@PathVariable("id") int id) {
        return productService.delete(id);
    }
}
