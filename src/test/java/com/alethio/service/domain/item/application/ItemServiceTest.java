package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.domain.item.dto.ItemRequestStub;
import com.alethio.service.domain.item.dto.ItemStub;
import com.alethio.service.exception.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("아이템 관련 서비스 테스트")
class ItemServiceTest {

    ItemService itemService;

    @Mock FoodRepository foodRepository;

    ItemRequest itemRequestStub;
    Food foodStub;

    @BeforeEach
    void setUp() {
        foodRepository = mock(FoodRepository.class);
        itemService = new ItemService(foodRepository);

        itemRequestStub = ItemRequestStub.of("food", 1L);
        foodStub = ItemStub.of(1L, 100, "떡볶이");
    }

    @DisplayName("음식을 조회한다")
    @Test
    void getFood() {
        // given
        when(foodRepository.findById(anyLong()))
                .thenReturn(Optional.of(foodStub));

        // when
        Food food = itemService.getItem(itemRequestStub);

        // then
        assertThat(food.getName()).isEqualTo("떡볶이");
        assertThat(food.getQuantity()).isEqualTo(100);
    }

    @DisplayName("음식을 조회 시, 음식이 존재하지 않으면 에러를 발생시킨다")
    @Test
    void getFood_IfClothesIsNull_ThrowException() {
        // given
        when(foodRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        // when then
        assertThatThrownBy(() -> itemService.getItem(itemRequestStub))
                .hasMessage("존재하지 않는 아이템입니다.")
                .isInstanceOf(ItemNotFoundException.class);
    }

    @DisplayName("음식 조회 시, 재고가 1 감소한다")
    @Test
    void getFood_IfSuccess_DecreaseQuantity() {
        // given
        when(foodRepository.findById(anyLong()))
                .thenReturn(Optional.of(foodStub));

        // when
        Food food = itemService.getItem(itemRequestStub);

        // then
        assertThat(food.getName()).isEqualTo("떡볶이");
        assertThat(food.getQuantity()).isEqualTo(99);
    }
}