package com.alethio.service.domain.item.domain.food;

import com.alethio.service.domain.item.domain.Item;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
public class Food extends Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FOOD_ID")
    private Long id;
}
