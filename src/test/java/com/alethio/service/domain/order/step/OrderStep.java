package com.alethio.service.domain.order.step;

import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.order.dto.OrderRequestStub;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class OrderStep {

    public static void 주문_생성_됨(ExtractableResponse<Response> response) {
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
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
