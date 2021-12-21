package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.db.entities.Order;
import com.example.foodorderingapplication.dto.food.FoodDto;
import com.example.foodorderingapplication.dto.order.OrderDetails;
import com.example.foodorderingapplication.dto.order.OrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface OrderController {

    @Operation(description = "Get users orders")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of orders",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = OrderDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No orders found",content = @Content)
            }
    )

    List<OrderDto> getUserOrders(Long id);


    @Operation(description = "Creates an order")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",description = "order created",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = OrderDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "Error",content = @Content)
            }
    )
    OrderDto createOrder(OrderDto orderDto);

}
