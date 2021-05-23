package com.alethio.service.domain.item.domain;

import com.alethio.service.domain.item.dto.ItemStub;
import com.alethio.service.exception.NoItemLeftException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("음식 관련 도메인 테스트")
class FoodTest {

    @DisplayName("음식 조회 시, 재고가 0이면 에러를 발생시킨다")
    @Test
    void decreaseQuantity_IfNoQuantityLeft_ThrowException() {
        // given
        Food food = ItemStub.of(1L, 0, "떡볶이");

        // when then
        assertThatThrownBy(() -> food.decreaseQuantity())
            .isInstanceOf(NoItemLeftException.class);
    }

    @DisplayName("음식 조회 시, 재고가 10개 미만인지 확인한다")
    @Test
    void hasShortStock_IfLessThan10_StockRequest() {
        // given
        Food food = ItemStub.of(1L, 9, "떡볶이");

        // when
        boolean hasEnoughStock = food.hasShortStock();

        // then
        assertThat(hasEnoughStock).isTrue();
    }
}