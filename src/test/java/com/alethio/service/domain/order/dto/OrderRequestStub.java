package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.domain.item.dto.ItemRequestStub;
import com.alethio.service.domain.order.dto.OrderRequest.ContactInfo;

import static org.springframework.test.util.ReflectionTestUtils.setField;

public class OrderRequestStub {

    public static OrderRequest of(String contactEmail, String contactName, String mobile, String itemType, Long id) {
        OrderRequest orderRequest = new OrderRequest();
        ContactInfo contactInfo = new ContactInfo();
        ItemRequest itemRequest = ItemRequestStub.of(itemType, id);

        setField(contactInfo, "contactEmail", contactEmail);
        setField(contactInfo, "contactName", contactName);
        setField(contactInfo, "mobile", mobile);

        setField(orderRequest, "contactInfo", contactInfo);
        setField(orderRequest, "itemRequest", itemRequest);
        return orderRequest;
    }
}
