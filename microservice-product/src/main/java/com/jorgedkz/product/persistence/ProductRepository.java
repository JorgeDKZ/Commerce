package com.jorgedkz.product.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgedkz.product.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
