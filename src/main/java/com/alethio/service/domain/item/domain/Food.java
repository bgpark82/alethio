package com.alethio.service.domain.item.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FOOD_ID")
    private Long id;

    private String name;

    private int quantity;
}
