package com.example.foodorderingapplication.services.Order;

import com.example.foodorderingapplication.dto.order.OrderDetails;
import com.example.foodorderingapplication.dto.order.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getOrders(Long id);
    OrderDto createOrder(OrderDto orderDto);

}
