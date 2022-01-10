package com.example.foodorderingapplication.controllers;


import com.example.foodorderingapplication.dto.order.OrderDetails;
import com.example.foodorderingapplication.dto.order.OrderDto;
import com.example.foodorderingapplication.services.Order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:4200")
public class OrderService implements OrderController{

    @Autowired
    OrderServiceImpl orderService;

    @Override
    @GetMapping
    public List<OrderDto> getUserOrders(Long id) {
        return orderService.getOrders(id);
    }

    @Override
    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }
}
