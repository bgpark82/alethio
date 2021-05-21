package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Clothes;
import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.dto.ItemRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("아이템 관련 서비스 테스트")
class ItemServiceTest {
    ItemService itemService;

    @BeforeEach
    void setUp() {
        itemService = new ItemService();
    }

    @DisplayName("음식을 조회한다")
    @Test
    void getClothes() {
        // given
        ItemRequest itemRequest = new ItemRequest();
        ReflectionTestUtils.setField(itemRequest, "itemType", "food");
        ReflectionTestUtils.setField(itemRequest, "id", 1L);

        // when
        Food food = itemService.getItem(itemRequest);

        // then
        assertThat(food.getName()).isEqualTo("떡볶이");
        assertThat(food.getQuantity()).isEqualTo(100);
    }
}