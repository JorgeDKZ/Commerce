package com.jorgedkz.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.product.entities.Product;
import com.jorgedkz.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product entity) {
        productService.saveProduct(entity);
    }

    @PostMapping("/update/{id}")
    public HttpStatus updateProduct(@PathVariable Long id, @RequestBody Product entity) {
        if (productService.updateProduct(id, entity)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);

    }

}
