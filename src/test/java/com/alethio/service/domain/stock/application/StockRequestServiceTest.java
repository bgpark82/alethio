package com.alethio.service.domain.stock.application;

import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.dto.ItemStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("재고 요청 관련 서비스 테스트")
class StockRequestServiceTest {

    StockRequestService stockRequestService;

    @BeforeEach
    void setUp() {
        stockRequestService = new StockRequestService();
    }

    @DisplayName("재고를 요청한다")
    @Test
    void requestStock() {
        // given
        Food 떡볶이 = ItemStub.of(1L, 9, "떡볶이");

        // when then
       assertThatThrownBy(() -> stockRequestService.requestStock(떡볶이))
               .doesNotThrowAnyException();
    }
}