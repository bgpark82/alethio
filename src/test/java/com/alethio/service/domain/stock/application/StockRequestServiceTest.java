package com.alethio.service.domain.stock.application;

import com.alethio.service.domain.stock.domain.StockRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("재고 요청 관련 서비스 테스트")
class StockRequestServiceTest {

    StockRequestService stockRequestService;
    StockRequestRepository stockRequestRepository;

    @BeforeEach
    void setUp() {
        stockRequestRepository = mock(StockRequestRepository.class);
        stockRequestService = new StockRequestServiceImpl(stockRequestRepository);
    }

    @DisplayName("재고를 요청한다")
    @Test
    void requestStock() {
        // when
        stockRequestService.requestStock("떡볶이", "food");

        // then
        verify(stockRequestRepository).save(any());
    }
}