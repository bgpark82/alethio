package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Clothes;
import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("아이템 관련 서비스 테스트")
class ItemServiceTest {

    ItemService itemService;
    @Mock
    FoodRepository foodRepository;

    @BeforeEach
    void setUp() {
        foodRepository = mock(FoodRepository.class);
        itemService = new ItemService(foodRepository);
    }

    @DisplayName("음식을 조회한다")
    @Test
    void getClothes() {
        // given
        ItemRequest itemRequest = new ItemRequest();
        ReflectionTestUtils.setField(itemRequest, "itemType", "food");
        ReflectionTestUtils.setField(itemRequest, "id", 1L);

        Food mock = new Food();
        ReflectionTestUtils.setField(mock, "id", 1L);
        ReflectionTestUtils.setField(mock, "quantity", 100);
        ReflectionTestUtils.setField(mock, "name", "떡볶이");

        when(foodRepository.findById(anyLong())).thenReturn(Optional.of(mock));

        // when
        Food food = itemService.getItem(itemRequest);

        // then
        assertThat(food.getName()).isEqualTo("떡볶이");
        assertThat(food.getQuantity()).isEqualTo(100);
    }
}