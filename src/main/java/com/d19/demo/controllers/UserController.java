package com.d19.demo.controllers;

import com.d19.demo.models.result.Result;
import com.d19.demo.models.result.ResultCode;
import com.d19.demo.models.result.ResultGenerator;
import com.d19.demo.models.user.User;
import com.d19.demo.repositories.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Result<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>();
        return ResultGenerator.genSuccessResult(users);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User userParam) {
        User user = userService.getUserByUsername(userParam.getUsername());
        if (user != null) {
            return ResultGenerator.genFailResult("Tên tài khoản đã tồn tại", ResultCode.FAIL);
        }

        return ResultGenerator.genSuccessResult(userService.register(userParam));
    }

    @PostMapping("/login")
    public Result login(@RequestBody User userParam) {
        User user = userService.getUserByUsernameAndPassword(userParam.getUsername(), userParam.getPassword());
        if (user == null) {
            return ResultGenerator.genFailResult("Tên tài khoản hoặc mật khẩu không đúng", ResultCode.FAIL);
        }

        return ResultGenerator.genSuccessResult("Đăng nhập thành công");
    }
}
