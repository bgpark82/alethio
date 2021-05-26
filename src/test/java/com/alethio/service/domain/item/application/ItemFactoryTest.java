package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.clothes.ClothesRepository;
import com.alethio.service.domain.item.domain.food.FoodRepository;
import com.alethio.service.exception.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("아이템 팩토리 관련 테스트")
class ItemFactoryTest {

    ItemFactory itemFactory;
    FoodRepository foodRepository;
    ClothesRepository clothesRepository;

    @BeforeEach
    void setUp() {
        foodRepository = mock(FoodRepository.class);
        clothesRepository = mock(ClothesRepository.class);
        itemFactory = new ItemFactoryImpl(foodRepository, clothesRepository);
    }

    @DisplayName("음식을 조회 시, 음식이 존재하지 않으면 에러를 발생시킨다")
    @Test
    void getFood_IfClothesIsNull_ThrowException() {
        // given
        when(foodRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        // when then
        assertThatThrownBy(() -> itemFactory.findItemByType(1L, "food"))
                .hasMessage("존재하지 않는 아이템입니다.")
                .isInstanceOf(ItemNotFoundException.class);
    }
}