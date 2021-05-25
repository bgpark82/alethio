package com.alethio.service.domain.item.dto;

import com.alethio.service.domain.item.domain.food.Food;
import com.alethio.service.domain.item.domain.Stock;
import org.springframework.test.util.ReflectionTestUtils;

public class FoodStub {

    public static Food of(Long id, int quantity, String name) {
        Food mock = new Food();
        Stock stock = new Stock();
        ReflectionTestUtils.setField(stock, "quantity", quantity);
        ReflectionTestUtils.setField(mock, "id", id);
        ReflectionTestUtils.setField(mock, "name", name);
        ReflectionTestUtils.setField(mock, "stock", stock);
        return mock;
    }
}
