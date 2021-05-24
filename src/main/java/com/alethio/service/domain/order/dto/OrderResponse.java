package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.order.domain.Order;
import lombok.Getter;

@Getter
public class OrderResponse {

    private Long id;
    private OrderUserResponse orderUser;
    private OrderItemResponse orderItem;

    public static OrderResponse of(Order order) {
        OrderResponse response = new OrderResponse();
        response.id = order.getId();
        response.orderUser = OrderUserResponse.of(order.getOrderUser());
        response.orderItem = OrderItemResponse.of(order.getOrderItem());
        return response;
    }
}
