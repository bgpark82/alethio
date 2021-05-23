package com.alethio.service.domain.order.acceptance;

import com.alethio.service.common.AcceptanceTest;
import com.alethio.service.domain.order.dto.OrderRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.alethio.service.domain.order.step.OrderStep.*;

@DisplayName("주문 관련 인수 테스트")
public class OrderAcceptanceTest extends AcceptanceTest {

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
    void orderFood_IfClothesIsNull_ThrowException() {
        // given
        OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "food", 2L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        주문_생성_실패_됨(response);
    }
}
