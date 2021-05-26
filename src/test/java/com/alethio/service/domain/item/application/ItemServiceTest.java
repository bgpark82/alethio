package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.item.domain.ItemRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.domain.item.dto.ItemRequestStub;
import com.alethio.service.domain.item.dto.FoodStub;
import com.alethio.service.exception.NoItemLeftException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("아이템 관련 서비스 테스트")
class ItemServiceTest {

    ItemService itemService;

    @Mock ItemFactory itemFactory;

    ItemRequest itemRequestStub;
    Item itemStub;
    String 떡볶이, 음식_타입;
    int 남은_재고;

    @BeforeEach
    void setUp() {
        itemFactory = mock(ItemFactory.class);
        itemService = new ItemService(itemFactory);

        떡볶이 = "떡볶이";
        남은_재고 = 99;
        음식_타입 = "food";
        itemRequestStub = ItemRequestStub.of(음식_타입, 1L);
        itemStub = FoodStub.of(1L, 100, 떡볶이);
    }

    @DisplayName("음식을 조회한다")
    @Test
    void getFood() {
        // given
        when(itemFactory.findItemByType(anyLong(), anyString()))
                .thenReturn(itemStub);

        // when
        Item food = itemService.getItem(itemRequestStub);

        // then
        assertThat(food.getName()).isEqualTo(떡볶이);
        assertThat(food.getQuantity()).isEqualTo(남은_재고);
    }



    @DisplayName("음식 조회 시, 재고가 1 감소한다")
    @Test
    void getFood_IfSuccess_DecreaseQuantity() {
        // given
        when(itemFactory.findItemByType(anyLong(), anyString()))
                .thenReturn(itemStub);

        // when
        Item food = itemService.getItem(itemRequestStub);

        // then
        assertThat(food.getName()).isEqualTo(떡볶이);
        assertThat(food.getQuantity()).isEqualTo(남은_재고);
    }

    @DisplayName("음식 조회 시, 재고가 0이면 에러를 발생시킨다")
    @Test
    void getFood_IfNoQuantityLeft_ThrowException() {
        // given
        Item emptyFood = FoodStub.of(1L, 0, 떡볶이);
        when(itemFactory.findItemByType(anyLong(), anyString()))
                .thenReturn(emptyFood);

        // when then
        assertThatThrownBy(() -> itemService.getItem(itemRequestStub))
                .hasMessage("재고가 없습니다.")
                .isInstanceOf(NoItemLeftException.class);
    }

    @DisplayName("음식 조회 시, 재고가 10개 미만이면 입고요청을 한다")
    @Test
    void getFood_IfLessThan10_StockRequest() {
        // given
        Item shortFood = FoodStub.of(1L, 10, 떡볶이);
        when(itemFactory.findItemByType(anyLong(), anyString()))
                .thenReturn(shortFood);

        // when
        Item food = itemService.getItem(itemRequestStub);

        // then
        assertThat(food.getName()).isEqualTo(떡볶이);
        assertThat(food.getQuantity()).isEqualTo(9);
    }
}