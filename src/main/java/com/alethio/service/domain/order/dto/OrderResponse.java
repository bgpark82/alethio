package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.order.domain.Order;
import lombok.Getter;

// TODO: ResponseStub 생성
@Getter
public class OrderResponse {

    private Long id;
    private String userEmail;
    private OrderItemResponse orderItem;

    public static OrderResponse of(Order order) {
        OrderResponse response = new OrderResponse();
        response.id = order.getId();
        response.userEmail = order.getUserEmail();
        response.orderItem = OrderItemResponse.of(order.getOrderItem());
        return response;
    }
}
