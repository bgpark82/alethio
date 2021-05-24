package com.alethio.service.domain.order.domain;

import lombok.Getter;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "order", cascade = PERSIST)
    private OrderItem orderItem;

    @OneToOne(cascade = PERSIST)
    private OrderUser orderUser;

    public static Order create(final OrderUser orderUser, final OrderItem orderItem) {
        final Order order = new Order();
        order.orderUser = orderUser;
        order.addOrderItem(orderItem);
        return order;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        orderItem.addOrder(this);
    }
}
