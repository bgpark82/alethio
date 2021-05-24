package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.domain.item.dto.ItemRequestStub;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class OrderRequestStub {

    public static OrderRequest of(String contactEmail, String contactName, String mobile, String itemType, Long id) {
        OrderRequest orderRequest = new OrderRequest();
        OrderUserRequest orderUserRequest = new OrderUserRequest();
        ItemRequest itemRequest = ItemRequestStub.of(itemType, id);

        setField(orderUserRequest, "contactEmail", contactEmail);
        setField(orderUserRequest, "contactName", contactName);
        setField(orderUserRequest, "mobile", mobile);

        setField(orderRequest, "userRequest", orderUserRequest);
        setField(orderRequest, "itemRequest", itemRequest);
        return orderRequest;
    }
}
