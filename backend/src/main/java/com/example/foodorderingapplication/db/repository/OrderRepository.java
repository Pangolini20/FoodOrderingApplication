package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Order;
import com.example.foodorderingapplication.dto.order.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select new com.example.foodorderingapplication.dto.order.OrderDto(o.id,u.id,ur.id,r.id,o.time) from Order o join o.restaurant r join o.deliveryGuy u join o.receiver ur")
    List<OrderDto> getOrdersByUserId(Long id);

}
