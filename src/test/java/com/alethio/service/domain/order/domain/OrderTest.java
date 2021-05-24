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
        OrderItem orderItem = OrderItem.create(1L, "떡볶이", 10);
        OrderUser orderuser = OrderUser.create("bgpark", "bgpark82@gmail.com", "01045808682");

        // when
        Order order = Order.create(orderuser, orderItem);

        // then
        assertThat(order.getOrderItem()).isEqualTo(orderItem);
        assertThat(order.getOrderUser()).isEqualTo(orderuser);
    }
}