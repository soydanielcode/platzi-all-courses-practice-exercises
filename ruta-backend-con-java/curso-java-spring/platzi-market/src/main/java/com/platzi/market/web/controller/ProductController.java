package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        return productService.getProduct(id)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    private ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int id) {
        return new ResponseEntity<>(productService.getByCategory(id),HttpStatus.OK);
    }

    @GetMapping("/barcode/{barcode}")
    private ResponseEntity<Product> getProductByBarcode(@PathVariable("barcode") String barcode) {
        return productService.getProductByBarcode(barcode)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/shortage/{quality}")
    private ResponseEntity<List<Product>> getShortage(@PathVariable("quality") int quality) {
        return productService.getShortage(quality)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    private ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable("id") int id) {
        return productService.delete(id)?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
