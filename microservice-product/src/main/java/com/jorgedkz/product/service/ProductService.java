package com.jorgedkz.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgedkz.product.entities.Product;
import com.jorgedkz.product.repository.ProductRepository;

@Service
public class ProductService implements InterfaceProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
       return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public boolean updateProduct(Long id, Product product) {
       Product existProduct = productRepository.findById(id).orElse(null);
         if (existProduct != null) {
              existProduct.setName(product.getName());
              existProduct.setDescription(product.getDescription());
              existProduct.setPrice(product.getPrice());
              existProduct.setStock(product.getStock());
              productRepository.save(existProduct);
              return true;
         }

         return false;

    }

}
