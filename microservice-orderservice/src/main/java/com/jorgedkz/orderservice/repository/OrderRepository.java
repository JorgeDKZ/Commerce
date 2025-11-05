package com.jorgedkz.orderservice.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgedkz.orderservice.entity.OrderService;

@Repository
public interface OrderRepository extends CrudRepository<OrderService, Long> {

    @Query("SELECT o.idProduct FROM OrderService o WHERE o.idClient = :idClient")
    public List<Long> findAllProductsFromClient(Long idClient);

    @Query("SELECT o.idClient FROM OrderService o WHERE o.idProduct = :idProduct")
    public List<Long> findAllClientsFromProducts(Long idProduct);
}
