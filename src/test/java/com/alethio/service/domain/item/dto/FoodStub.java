package com.alethio.service.domain.item.dto;

import com.alethio.service.domain.item.domain.Food;
import org.springframework.test.util.ReflectionTestUtils;

public class FoodStub {

    public static Food of(Long id, int quantity, String name) {
        Food mock = new Food();
        ReflectionTestUtils.setField(mock, "id", id);
        ReflectionTestUtils.setField(mock, "quantity", quantity);
        ReflectionTestUtils.setField(mock, "name", name);
        return mock;
    }
}
