package com.alethio.service.domain.item.domain;

import com.alethio.service.exception.NoItemLeftException;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@ToString
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

    @OneToMany(mappedBy = "item", cascade = PERSIST, fetch = LAZY)
    private List<StockRequest> request;

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

    public boolean hasShortStock() {
        return this.quantity < STOCK_REQUEST_THRESHOLD;
    }
}
