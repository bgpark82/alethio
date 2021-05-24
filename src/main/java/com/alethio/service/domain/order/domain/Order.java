package com.alethio.service.domain.order.domain;

import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    private String userEmail;

    @OneToOne(mappedBy = "order", cascade = PERSIST)
    private OrderItem orderItem;

    public static Order create(final String userEmail, final OrderItem orderItem) {
        final Order order = new Order();
        order.userEmail = userEmail;
        order.addOrderItem(orderItem);
        return order;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        orderItem.addOrder(this);
    }
}
