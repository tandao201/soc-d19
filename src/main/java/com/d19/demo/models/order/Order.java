package com.d19.demo.models.order;

import com.d19.demo.models.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "total_price")
    private int totalPrice;
    private String status;
    @OneToMany
    private Set<Product> products;

    public Order(int idUser, int totalPrice, String status) {
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order() {

    }
}
