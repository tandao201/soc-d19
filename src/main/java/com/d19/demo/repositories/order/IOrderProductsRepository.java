package com.d19.demo.repositories.order;

import com.d19.demo.models.order.OrdersProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderProductsRepository extends JpaRepository<OrdersProducts, Integer> {
}
