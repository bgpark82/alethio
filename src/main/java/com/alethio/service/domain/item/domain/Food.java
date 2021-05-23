package com.alethio.service.domain.item.domain;

import com.alethio.service.exception.NoItemLeftException;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class Food {

    private static final int ZERO_QUANTITY = 0;
    private static final int STOCK_REQUEST_THRESHOLD = 10;
    private static final int DECREASE_AMOUNT = 1;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FOOD_ID")
    private Long id;

    private String name;

    private int quantity;

    // TODO: 객체로 분리
    public void decreaseQuantity() {
        final int restQuantity = this.quantity - DECREASE_AMOUNT;
        checkEmpty(restQuantity);
        this.quantity = restQuantity;
    }

    private void checkEmpty(int restQuantity) {
        if(restQuantity < ZERO_QUANTITY) {
            throw new NoItemLeftException();
        }
    }
}
