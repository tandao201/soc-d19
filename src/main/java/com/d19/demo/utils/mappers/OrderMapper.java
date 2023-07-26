package com.d19.demo.utils.mappers;

import com.d19.demo.models.order.Order;
import com.d19.demo.models.order.OrderCreate;

public class OrderMapper {
    public static Order orderCreateToOrder(OrderCreate orderCreate) {
        return new Order(
                orderCreate.getIdUser(),
                orderCreate.getTotalPrice(),
                orderCreate.getStatus()
        );
    }
}
