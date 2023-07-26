package com.d19.demo.repositories.order;

import com.d19.demo.models.order.Order;
import com.d19.demo.models.order.OrdersProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderProductsRepository iOrderProductsRepository;
    @Autowired
    IOrderRepository iOrderRepository;

    public List<Order> getAllOrderByUserId(int userId) {
        return iOrderRepository.findByIdUser(userId);
    }

    public Order getOrderById(int orderId) {
        Optional<Order> optional = iOrderRepository.findById(orderId);
        return optional.orElse(null);
    }

    public Order createOrder(Order order) {
        return iOrderRepository.save(order);
    }

    public Order updateOrderStatus(int orderId, String status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            return iOrderRepository.save(order);
        }
        return null;
    }

    public void saveOrdersProducts(List<OrdersProducts> ordersProducts) {
        iOrderProductsRepository.saveAll(ordersProducts);
    }
}
