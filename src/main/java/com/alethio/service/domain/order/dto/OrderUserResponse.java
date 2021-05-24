package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.order.domain.OrderUser;
import lombok.Getter;

@Getter
public class OrderUserResponse {

    private Long id;
    private String name;
    private String email;
    private String mobile;


    public static OrderUserResponse of(OrderUser orderUser) {
        OrderUserResponse response = new OrderUserResponse();
        response.id = orderUser.getId();
        response.name = orderUser.getName();
        response.email = orderUser.getEmail();
        response.mobile = orderUser.getMobile();
        return response;
    }
}
