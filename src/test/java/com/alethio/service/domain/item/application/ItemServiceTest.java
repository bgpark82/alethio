package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.domain.item.dto.ItemRequestStub;
import com.alethio.service.domain.item.dto.ItemStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("아이템 관련 서비스 테스트")
class ItemServiceTest {

    ItemService itemService;

    @Mock FoodRepository foodRepository;

    @BeforeEach
    void setUp() {
        foodRepository = mock(FoodRepository.class);
        itemService = new ItemService(foodRepository);
    }

    @DisplayName("음식을 조회한다")
    @Test
    void getClothes() {
        // given
        ItemRequest itemRequest = ItemRequestStub.of("food", 1L);
        Food stub = ItemStub.of(1L, 100, "떡볶이");
        when(foodRepository.findById(anyLong())).thenReturn(Optional.of(stub));

        // when
        Food food = itemService.getItem(itemRequest);

        // then
        assertThat(food.getName()).isEqualTo("떡볶이");
        assertThat(food.getQuantity()).isEqualTo(100);
    }
}