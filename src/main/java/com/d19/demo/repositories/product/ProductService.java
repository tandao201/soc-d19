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

    public Product getProductById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    public int updateQuantity(int id, int quantity) {
        Product product = getProductById(id);
        if (product != null) {
            product.setQuantity(product.getQuantity() - quantity);
            iProductRepository.save(product);
            return 1;
        }
        return 0;
    }
}
