package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.order.domain.OrderItem;
import lombok.Getter;

@Getter
public class OrderItemResponse {

    private Long id;
    private String name;
    private int quantity;

    public static OrderItemResponse of(OrderItem orderItem) {
        OrderItemResponse response = new OrderItemResponse();
        response.id = orderItem.getId();
        response.name = orderItem.getFoodName();
        response.quantity = orderItem.getFoodQuantity();
        return response;
    }
}
