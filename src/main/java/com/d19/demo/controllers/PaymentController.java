package com.d19.demo.controllers;

import com.d19.demo.models.credit.CreditCard;
import com.d19.demo.models.order.Order;
import com.d19.demo.models.result.Result;
import com.d19.demo.models.result.ResultCode;
import com.d19.demo.models.result.ResultGenerator;
import com.d19.demo.repositories.order.OrderService;
import com.d19.demo.utils.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    OrderService orderService;

    @PostMapping("/{orderId}")
    public Result payForOrder(@PathVariable int orderId, @RequestBody CreditCard creditCard) {
        if (!Validate.validateCreditCard(creditCard)) {
            return ResultGenerator.genFailResult("Vui lòng nhập đầy đủ thông tin thẻ", ResultCode.FAIL);
        }
        Order orderDb = orderService.updateOrderStatus(orderId, "paid");
        if (orderDb == null) {
            return ResultGenerator.genFailResult("Đơn hàng không tồn tại", ResultCode.FAIL);
        }
        return ResultGenerator.genSuccessResult(orderDb);
    }
}
