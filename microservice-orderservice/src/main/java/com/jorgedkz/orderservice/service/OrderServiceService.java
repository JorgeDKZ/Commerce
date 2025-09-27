package com.jorgedkz.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgedkz.orderservice.entity.OrderService;
import com.jorgedkz.orderservice.persistence.OrderRepository;

@Service
public class OrderServiceService implements InterfaceOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(OrderService order) {
        orderRepository.save(order);
    }

    @Override
    public OrderService getOrderById(Long id) {
      return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderService> getAllOrders() {
        return (List<OrderService>) orderRepository.findAll();
    }

    @Override
    public List<Long> getAllProductsFromClient(Long idClient) {
        return orderRepository.findAllProductsFromClient(idClient);
    }

    @Override
    public List<Long> getAllClientsFromProducts(Long idProduct) {
        return orderRepository.findAllClientsFromProducts(idProduct);
    }

}
