package com.alethio.service.domain.order.documentation;

import com.alethio.service.common.DocumentationTest;
import com.alethio.service.domain.order.dto.OrderRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static com.alethio.service.domain.order.step.OrderStep.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

public class OrderDocumentationTest extends DocumentationTest {


    @DisplayName("음식을 주문한다")
    @Test
    void orderFood() {
        // given
        OrderRequest request = 주문_생성_스텁("test@test.com", "구매자", "01099999999", "food", 1L);

        // when
        ExtractableResponse<Response> response = RestAssured
                .given(spec).log().all()
                .filter(document("order",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("contactInfo.contactEmail").type(JsonFieldType.STRING).description("상품 주문인의 이메일 주소"),
                                fieldWithPath("contactInfo.contactName").type(JsonFieldType.STRING).description("상품 주문인의 이름"),
                                fieldWithPath("contactInfo.mobile").type(JsonFieldType.STRING).description("상품 주문인의 전화번호"),
                                fieldWithPath("items.itemType").type(JsonFieldType.STRING).description("상품의 타입 (ex. food, clothes 등..)"),
                                fieldWithPath("items.id").type(JsonFieldType.NUMBER).description("상품의 아이디")),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("주문 아이디"),
                                fieldWithPath("orderUser.id").type(JsonFieldType.NUMBER).description("상품 주문인의 아이디"),
                                fieldWithPath("orderUser.name").type(JsonFieldType.STRING).description("상품 주문인의 이름"),
                                fieldWithPath("orderUser.email").type(JsonFieldType.STRING).description("상품 주문인의 이메일"),
                                fieldWithPath("orderUser.mobile").type(JsonFieldType.STRING).description("상품 주문인의 전화번호"),
                                fieldWithPath("orderItem.id").type(JsonFieldType.NUMBER).description("주문 상품의 아이디"),
                                fieldWithPath("orderItem.name").type(JsonFieldType.STRING).description("주문 상품의 이름"),
                                fieldWithPath("orderItem.quantity").type(JsonFieldType.NUMBER).description("주문 상품의 남은 수량"))
                        ))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/order")
                .then().log().all().extract();

        // then
        주문_생성_됨(response, "test@test.com","떡볶이", 99);
    }
}
