package com.jorgedkz.product.service;

import java.util.List;

import com.jorgedkz.product.entities.Product;

public interface InterfaceProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public void saveProduct(Product product);

    public boolean updateProduct(Long id, Product product);

}
