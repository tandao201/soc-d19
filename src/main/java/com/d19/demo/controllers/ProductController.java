package com.d19.demo.controllers;

import com.d19.demo.models.product.Product;
import com.d19.demo.models.result.Result;
import com.d19.demo.models.result.ResultCode;
import com.d19.demo.models.result.ResultGenerator;
import com.d19.demo.repositories.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Result getAllProducts() {
        return ResultGenerator.genSuccessResult(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public Result getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResultGenerator.genFailResult("Sản phẩm không tồn tại", ResultCode.FAIL);
        }
        return ResultGenerator.genSuccessResult(product);
    }

    @PostMapping("/status")
    public Result checkQuantityStatus(@RequestBody Product productParam) {
        Product product = productService.getProductByName(productParam.getProductName().toLowerCase());
        if (product == null) {
            return ResultGenerator.genFailResult("Sản phẩm không tồn tại", ResultCode.FAIL);
        }

        if (product.getQuantity() >= productParam.getQuantity() )
            return ResultGenerator.genSuccessResult("Số lượng tồn kho đáp ứng đủ");
        else {
            int quantity = Math.abs(product.getQuantity() - productParam.getQuantity());
            return ResultGenerator.genSuccessResult("Vượt quá số lượng còn tồn kho " + quantity + " sản phẩm");
        }
    }
}
