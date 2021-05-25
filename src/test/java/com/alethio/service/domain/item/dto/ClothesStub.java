package com.alethio.service.domain.item.dto;

import com.alethio.service.domain.item.domain.Stock;
import com.alethio.service.domain.item.domain.clothes.Clothes;
import org.springframework.test.util.ReflectionTestUtils;

public class ClothesStub {

    public static Clothes of(Long id, int quantity, String name) {
        Clothes mock = new Clothes();
        Stock stock = new Stock();
        ReflectionTestUtils.setField(stock, "quantity", quantity);
        ReflectionTestUtils.setField(mock, "id", id);
        ReflectionTestUtils.setField(mock, "name", name);
        ReflectionTestUtils.setField(mock, "stock", stock);
        return mock;
    }
}
