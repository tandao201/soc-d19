package com.d19.demo.repositories.order;

import com.d19.demo.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByIdUser(int idUser);
}
