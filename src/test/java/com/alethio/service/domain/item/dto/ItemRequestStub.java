package com.alethio.service.domain.item.dto;

import org.springframework.test.util.ReflectionTestUtils;

public class ItemRequestStub {

    public static ItemRequest of(String itemType, long id) {
        ItemRequest itemRequest = new ItemRequest();
        ReflectionTestUtils.setField(itemRequest, "itemType", itemType);
        ReflectionTestUtils.setField(itemRequest, "id", id);
        return itemRequest;
    }
}
