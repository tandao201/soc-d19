package com.d19.demo.repositories.product;

import com.d19.demo.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByProductName(String productName);
}
