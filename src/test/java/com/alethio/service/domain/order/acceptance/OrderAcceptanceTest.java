package com.alethio.service.domain.order.acceptance;

import com.alethio.service.common.AcceptanceTest;
import com.alethio.service.domain.item.domain.clothes.ClothesRepository;
import com.alethio.service.domain.item.domain.food.FoodRepository;
import com.alethio.service.domain.item.dto.ClothesStub;
import com.alethio.service.domain.item.dto.FoodStub;
import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.stock.domain.StockRequest;
import com.alethio.service.domain.stock.domain.StockRequestRepository;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static com.alethio.service.domain.order.step.OrderStep.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주문 관련 인수 테스트")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderAcceptanceTest extends AcceptanceTest {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    ClothesRepository clothesRepository;
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
        주문_생성_됨(response, "test@test.com","떡볶이", 99);
    }

    @DisplayName("음식을 주문한다")
    @Test
    void orderFood_WhenParameterHasSpace() {
        // given
        OrderRequest request = 주문_생성_스텁("  test@test.com   ", "   구매자  ", "   01099999999  ", "food", 1L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        주문_생성_됨(response, "test@test.com","떡볶이", 99);
    }

    @DisplayName("옷을 주문한다")
    @Test
    void orderClothes() {
        // given
        OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "clothes", 1L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        주문_생성_됨(response, "test@test.com","A청바지", 99);
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
        음식_생성_요청(9, "어묵");
        final OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "food", 2L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        재고_요청_생성_됨(1L, 100, "어묵123", "어묵");
        주문_생성_됨(response, "test@test.com", "어묵",8);
    }

    @DisplayName("옷 주문 시, 10개 미만이 남으면 재고 요청한다")
    @Test
    void orderClothes_IfClothesLessThan10Left_RequestMoreStock() {
        // given
        옷_생성_요청(9, "A청바지");
        OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "clothes", 2L);

        // when
        ExtractableResponse<Response> response = 주문_생성_요청(request);

        // then
        재고_요청_생성_됨(1L, 100, "123A청바지", "A청바지");
        주문_생성_됨(response, "test@test.com","A청바지", 8);
    }

    private void 음식_생성_요청(int quantity, String name) {
        foodRepository.save(FoodStub.of(null, quantity, name));
    }

    private void 옷_생성_요청(int quantity, String name) {
        clothesRepository.save(ClothesStub.of(null, quantity, name));
    }

    private void 재고_요청_생성_됨(Long id, int amount, String code, String name) {
        final StockRequest stockRequest = stockRequestRepository.findById(id).get();
        assertThat(stockRequest.getAmount()).isEqualTo(amount);
        assertThat(stockRequest.getCode()).isEqualTo(code);
        assertThat(stockRequest.getName()).isEqualTo(name);
    }
}
