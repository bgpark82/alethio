package com.alethio.service.domain.order.dto;

import lombok.Getter;

@Getter
public class OrderUserRequest {

    private String contactEmail;
    private String contactName;
    private String mobile;
}
