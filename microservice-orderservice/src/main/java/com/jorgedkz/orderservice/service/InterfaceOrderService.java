package com.jorgedkz.orderservice.service;

import java.util.List;

import com.jorgedkz.orderservice.entity.OrderService;

public interface InterfaceOrderService {

    public void saveOrder(OrderService order);

    public OrderService getOrderById(Long id);

    public List<OrderService> getAllOrders();

    public List<Long> getAllProductsFromClient(Long idClient);

    public List<Long> getAllClientsFromProducts(Long idProduct);
}
