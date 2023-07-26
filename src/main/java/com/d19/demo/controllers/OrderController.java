package com.d19.demo.controllers;

import com.d19.demo.models.order.Order;
import com.d19.demo.models.order.OrderCreate;
import com.d19.demo.models.order.OrdersProducts;
import com.d19.demo.models.result.Result;
import com.d19.demo.models.result.ResultCode;
import com.d19.demo.models.result.ResultGenerator;
import com.d19.demo.repositories.order.OrderService;
import com.d19.demo.utils.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{userId}")
    public Result getAllOrdersByUserId(@PathVariable int userId) {
        List<Order> orders = orderService.getAllOrderByUserId(userId);
        if (orders == null) {
            return ResultGenerator.genSuccessResult(new ArrayList<>());
        }
        return ResultGenerator.genSuccessResult(orders);
    }

    @PostMapping("/{userId}")
    public Result createOrder(@PathVariable int userId, @RequestBody OrderCreate orderCreate) {
        orderCreate.setIdUser(userId);
        Order order = orderService.createOrder(OrderMapper.orderCreateToOrder(orderCreate));
        List<OrdersProducts> ordersProducts = new ArrayList<>();
        for (Integer id: orderCreate.getProductsId()) {
            ordersProducts.add(new OrdersProducts(order.getId(), id));
        }
        orderService.saveOrdersProducts(ordersProducts);
        return ResultGenerator.genSuccessResult("Đặt hàng thành công");
    }

    @GetMapping("/status/{orderId}")
    public Result checkStatusOrder(@PathVariable int orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResultGenerator.genFailResult("Đơn hàng không tồn tại", ResultCode.FAIL);
        }
        Map<String , String> result = new HashMap<>();
        result.put("status", order.getStatus());
        return ResultGenerator.genSuccessResult(result);
    }
}
