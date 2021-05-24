package com.alethio.service.domain.order.acceptance;

import com.alethio.service.common.AcceptanceTest;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.dto.ItemStub;
import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.stock.domain.StockRequestRepository;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.alethio.service.domain.order.step.OrderStep.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주문 관련 인수 테스트")
public class OrderAcceptanceTest extends AcceptanceTest {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    StockRequestRepository stockRequestRepository;

    @DisplayName("음식을 주문한다")
    @Test
    void orderFood() {
        // given
        OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "food", 1L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        주문_생성_됨(response, "떡볶이", 99);
    }

    @DisplayName("음식 주문 시, 음식이 존재하지 않으면 에러를 발생시킨다")
    @Test
    void orderFood_IfNoFoodLeft_ThrowException() {
        // given
        OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "food", 2L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        주문_생성_실패_됨(response);
    }

    @DisplayName("음식 주문 시, 10개 미만이 남으면 재고 요청한다")
    @Test
    void orderFood_IfFoodLessThan10Left_RequestMoreStock() {
        // given
        foodRepository.save(ItemStub.of(null, 9, "어묵"));
        final OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "food", 2L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        assertThat(stockRequestRepository.findById(1L).get().getAmount()).isEqualTo(100);
        주문_생성_됨(response, "어묵", 8);
    }
}
