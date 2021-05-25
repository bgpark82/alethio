package com.alethio.service.domain.stock.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("재고 타입 관련 테스트")
class StockTypeTest {

    @DisplayName("음식 재고 요청 코드를 생성한다")
    @Test
    void getCode_WhenRequestFoodStock() {
        // given
        StockType food = StockType.valueOf("food");

        // when
        String 떡볶이 = food.getCode("떡볶이");

        // then
        assertThat(떡볶이).isEqualTo("떡볶이123");
    }

    @DisplayName("옷 재고 요청 코드를 생성한다")
    @Test
    void getCode_WhenRequestClothesStock() {
        // given
        StockType food = StockType.valueOf("clothes");

        // when
        String 떡볶이 = food.getCode("A청바지");

        // then
        assertThat(떡볶이).isEqualTo("123A청바지");
    }
}