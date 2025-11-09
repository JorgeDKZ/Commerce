package com.jorgedkz.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jorgedkz.orderservice.repository.DTO.ProductDTO;

@FeignClient(name = "microservice-product", path = "/api/products")
public interface ProductComunication {

    @GetMapping("/search/{id}")
    public ResponseEntity<ProductDTO> findProduct(@PathVariable Long id);

    @PostMapping("/update/{id}")
    public HttpStatus updateProduct(@PathVariable Long id, @RequestBody ProductDTO entity);
}
