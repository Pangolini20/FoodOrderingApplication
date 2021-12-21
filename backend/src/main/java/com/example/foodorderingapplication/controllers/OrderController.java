package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.order.OrderDetails;
import com.example.foodorderingapplication.dto.order.OrderDto;

import java.util.List;

public interface OrderController {

    List<OrderDto> getUserOrders(Long id);
    OrderDto createOrder(OrderDto orderDto);

}
