package com.alethio.service.domain.order.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class OrderItem {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private Long foodId;

    public static OrderItem create(Long foodId) {
        final OrderItem orderItem = new OrderItem();
        orderItem.foodId = foodId;
        return orderItem;
    }

    public void addOrder(Order order) {
        order.addOrderItem(this);
        this.order = order;
    }
}
