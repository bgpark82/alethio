package com.alethio.service.domain.item.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CLOTHES_ID")
    private Long id;

    private String name;

    private String quantity;
}
