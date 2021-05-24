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

    private String userName;

    @OneToMany(mappedBy = "order", cascade = PERSIST)
    private List<OrderItem> orderItems = new ArrayList<>();

    public static Order create(final String userName, final OrderItem ...orderItem) {
        final Order order = new Order();
        order.userName = userName;
        Arrays.stream(orderItem).forEach(oi -> oi.addOrder(order));
        return order;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }
}
