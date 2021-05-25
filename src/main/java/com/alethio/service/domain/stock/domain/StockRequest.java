package com.alethio.service.domain.stock.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class StockRequest {

    private static final String CLOTHES_TYPE = "clothes";
    private static final String FOOD_TYPE = "food";
    private static final String ENCRYPT_CODE = "123";
    private static final int REQUEST_AMOUNT = 100;

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String code;

    private int amount;

    public static StockRequest create(String name, String type) {
        StockRequest stockRequest = new StockRequest();
        stockRequest.code = getCode(name, type);;
        stockRequest.name = name;
        stockRequest.amount = REQUEST_AMOUNT;
        return stockRequest;
    }

    // TODO: enum으로 분리
    private static String getCode(String name, String type) {
        switch (type) {
            case FOOD_TYPE:
                return name + ENCRYPT_CODE;
            case CLOTHES_TYPE:
                return ENCRYPT_CODE + name;
            default:
                return null;
        }
    }
}
