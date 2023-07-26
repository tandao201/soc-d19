package com.d19.demo.models.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreate extends Order {
    private List<Integer> productsId;

    OrderCreate() {
        super();
    };
}
