package com.alethio.service.domain.stock.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class StockRequest {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String code;

    private int amount;
}
