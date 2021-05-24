package com.alethio.service.domain.order.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    private String userName;

    @OneToMany(mappedBy = "order", cascade = PERSIST)
    private List<OrderItem> orderItems;
}
