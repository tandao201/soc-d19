package com.d19.demo.repositories.product;

import com.d19.demo.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository iProductRepository;

    public Product getProductByName(String productName) {
        return iProductRepository.getProductByProductName(productName);
    }

    public List<Product> getAllProducts() {
        return iProductRepository.findAll();
    }
}
