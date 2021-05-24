package com.alethio.service.domain.order.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주문 관련 도메인 테스트")
class OrderTest {

    @DisplayName("주문을 생성한다")
    @Test
    void create() {
        // given
        OrderItem orderItem1 = OrderItem.create(1L);
        OrderItem orderItem2 = OrderItem.create(2L);

        // when
        Order order = Order.create("bgpark", orderItem1, orderItem2);

        // then
        assertThat(order.getOrderItems()).containsExactly(orderItem1, orderItem2);
        assertThat(orderItem1.getOrder()).isEqualTo(order);
        assertThat(orderItem2.getOrder()).isEqualTo(order);
    }
}