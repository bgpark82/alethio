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

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private Long foodId;

    private String foodName;

    private int foodQuantity;

    public static OrderItem create(Long foodId, String foodName, int foodQuantity) {
        final OrderItem orderItem = new OrderItem();
        orderItem.foodId = foodId;
        orderItem.foodName = foodName;
        orderItem.foodQuantity = foodQuantity;
        return orderItem;
    }

    public void addOrder(Order order) {
        this.order = order;
    }
}
