package com.alethio.service.domain.order.dto;

public class OrderRequestStub {

    public static OrderRequest of(String contactEmail, String contactName, String mobile, String itemType, int id) {
        return new OrderRequest(contactEmail, contactName, mobile, itemType, id);
    }
}
