package com.alethio.service.domain.order.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주문 고객 관련 도메인 테스트")
class OrderUserTest {

    @DisplayName("주문 고객 생성 시, 이름, 전화번호, 이메일의 좌우공백을 제거한다")
    @Test
    void trim() {
        // given when
        OrderUser orderUser = OrderUser.create("   구매자   ", "test@test.com   ", "01099999999    ");

        // then
        assertThat(orderUser.getEmail()).isEqualTo("test@test.com");
        assertThat(orderUser.getName()).isEqualTo("구매자");
        assertThat(orderUser.getMobile()).isEqualTo("01099999999");
    }
}