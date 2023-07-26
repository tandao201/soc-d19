package com.d19.demo.models.order;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders_products")
public class OrdersProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "products_id")
    private int productId;

    public OrdersProducts(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrdersProducts() {

    }
}
