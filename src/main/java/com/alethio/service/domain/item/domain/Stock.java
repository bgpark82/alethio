package com.alethio.service.domain.item.domain;

import com.alethio.service.exception.NoItemLeftException;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Stock {

    private static final int ZERO_QUANTITY = 0;
    private static final int STOCK_REQUEST_THRESHOLD = 10;
    private static final int DECREASE_AMOUNT = 1;

    private int quantity;

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

    public boolean hasShortStock() {
        return this.quantity < STOCK_REQUEST_THRESHOLD;
    }
}
