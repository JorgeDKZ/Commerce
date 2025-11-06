package com.jorgedkz.orderservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.orderservice.client.ClientComunication;
import com.jorgedkz.orderservice.client.ProductComunication;
import com.jorgedkz.orderservice.entity.OrderService;
import com.jorgedkz.orderservice.repository.DTO.ClientDTO;
import com.jorgedkz.orderservice.repository.DTO.ProductDTO;
import com.jorgedkz.orderservice.service.OrderServiceService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/orders")
public class OrderServiceController {

    @Autowired
    OrderServiceService orderServiceService;
    @Autowired
    ProductComunication productComunication;
    @Autowired
    ClientComunication clientComunication;

    @PostMapping("/create")
    public HttpStatus createOrder(@RequestBody OrderService entity) {
        ProductDTO productDTO = productComunication.findProduct(entity.getIdProduct()).getBody();
        ClientDTO clientDTO = clientComunication.findUser(entity.getIdClient()).getBody();
        if (productDTO == null || clientDTO == null) {
            return HttpStatus.NOT_FOUND;
        }
        if(productDTO.getStock()<=0) {
            return HttpStatus.BAD_REQUEST;
        }

        orderServiceService.saveOrder(entity);
        productDTO.setStock(productDTO.getStock() - 1);
        productComunication.updateProduct(entity.getIdProduct(), productDTO);
        return HttpStatus.CREATED;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        OrderService order = orderServiceService.getOrderById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderServiceService.getAllOrders());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAllOrderFromUser(@PathVariable Long id) {
        List<Long> numbers = orderServiceService.getAllProductsFromClient(id);
        List<ProductDTO> products = new ArrayList<ProductDTO>();
        for (int x = 0; x < numbers.size(); x++) {
            products.add(productComunication.findProduct(numbers.get(x)).getBody());
        }
        return ResponseEntity.ok(products);

    }

}
