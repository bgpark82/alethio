package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.order.dto.OrderRequest.ContactInfo;
import com.alethio.service.domain.order.dto.OrderRequest.Items;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class OrderRequestStub {

    public static OrderRequest of(String contactEmail, String contactName, String mobile, String itemType, Long id) {
        OrderRequest orderRequest = new OrderRequest();
        ContactInfo contactInfo = new ContactInfo();
        Items items = new Items();
        setField(contactInfo, "contactEmail", contactEmail);
        setField(contactInfo, "contactName", contactName);
        setField(contactInfo, "mobile", mobile);
        setField(items, "itemType", itemType);
        setField(items, "id", id);
        setField(orderRequest, "contactInfo", contactInfo);
        setField(orderRequest, "items", items);
        return orderRequest;
    }
}
