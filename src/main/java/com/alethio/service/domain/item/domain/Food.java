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

    private static final int DECREASE_AMOUNT = 1;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FOOD_ID")
    private Long id;

    private String name;

    private int quantity;

    public void decreaseQuantity() {
        if(this.quantity == 0) {
            throw new NoItemLeftException();
        }
        this.quantity -= DECREASE_AMOUNT;

    }
}
