package com.alethio.service.domain.stock.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class StockRequest {

    private static final String AMAZON_CODE = "아마존123";
    private static final int REQUEST_AMOUNT = 100;

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String code;

    private int amount;

    public static StockRequest create(String name) {
        StockRequest stockRequest = new StockRequest();
        stockRequest.code = AMAZON_CODE;
        stockRequest.name = name;
        stockRequest.amount = REQUEST_AMOUNT;
        return stockRequest;
    }
}
