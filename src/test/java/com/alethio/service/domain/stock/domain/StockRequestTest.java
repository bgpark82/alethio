package com.alethio.service.domain.stock.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("재고 요청 관련 도메인 테스트")
public class StockRequestTest {

    @DisplayName("음식 재고 요청을 생성한다")
    @Test
    void create_FoodStockRequest() {
        // given
        String code = StockType.valueOf("food").getCode("떡볶이");

        // when
        StockRequest stockRequest = StockRequest.create("떡볶이", code);

        // then
        assertThat(stockRequest.getCode()).isEqualTo("떡볶이123");
        assertThat(stockRequest.getAmount()).isEqualTo(100);
        assertThat(stockRequest.getName()).isEqualTo("떡볶이");
    }

    @DisplayName("옷 재고 요청을 생성한다")
    @Test
    void create_ClothesStockRequest() {
        // given
        String code = StockType.valueOf("clothes").getCode("A청바지");

        // when
        StockRequest stockRequest = StockRequest.create("A청바지", code);

        // then
        assertThat(stockRequest.getCode()).isEqualTo("123A청바지");
        assertThat(stockRequest.getAmount()).isEqualTo(100);
        assertThat(stockRequest.getName()).isEqualTo("A청바지");
    }
}
