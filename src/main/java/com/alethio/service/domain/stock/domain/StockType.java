package com.alethio.service.domain.stock.domain;

import java.util.function.Function;

public enum StockType {

    food("food", name -> name + "123"),
    clothes("clothes", name -> "123" + name);

    private String type;
    private Function<String, String> express;

    StockType(String type, Function<String, String> express) {
        this.type = type;
        this.express = express;
    }

    public String getCode(String name) {
        return express.apply(name);
    }
}
