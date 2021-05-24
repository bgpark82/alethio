package com.alethio.service.domain.order.step;

import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.order.dto.OrderRequestStub;
import com.alethio.service.domain.order.dto.OrderResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderStep {

    public static void 주문_생성_됨(ExtractableResponse<Response> response, String userEmail, String itemName, int quantity) {
        final OrderResponse orderResponse = response.as(OrderResponse.class);
        // TODO: 201 응답
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(orderResponse.getOrderUser().getEmail()).isEqualTo(userEmail);
        assertThat(orderResponse.getOrderItem().getName()).isEqualTo(itemName);
        assertThat(orderResponse.getOrderItem().getQuantity()).isEqualTo(quantity);
    }

    public static void 주문_생성_실패_됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        // TODO: BusinessException에서 body 객체 생성 (ex. ErrorCode)
    }

    public static ExtractableResponse<Response> 주문_생성_요청(OrderRequest request) {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/order")
                .then().log().all().extract();
    }

    public static OrderRequest 주문_생성_스텁(String contactEmail, String contactName, String mobile, String itemType, Long id) {
        return OrderRequestStub.of(contactEmail, contactName, mobile, itemType, id);
    }
}
