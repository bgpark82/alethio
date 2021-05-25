package com.alethio.service.domain.item.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item {

    private String name;

    private Stock stock;

    public void decreaseQuantity() {
        stock.decreaseQuantity();
    }

    public boolean hasShortStock() {
        return stock.hasShortStock();
    }

    public int getQuantity() {
        return stock.getQuantity();
    }

    public String getName() {
        return name;
    }

    public abstract Long getId();
}
