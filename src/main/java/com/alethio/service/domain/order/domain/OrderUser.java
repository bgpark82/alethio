package com.alethio.service.domain.order.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class OrderUser {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String mobile;

    public static OrderUser create(String contactName, String contactEmail, String mobile) {
        OrderUser orderUser = new OrderUser();
        orderUser.name = contactName;
        orderUser.email = contactEmail;
        orderUser.mobile = mobile;
        return orderUser;
    }
}
