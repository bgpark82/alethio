package com.alethio.service.domain.item.domain;

import javax.persistence.*;

@Entity
public class StockRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_REQUEST_ID")
    private Long id;

    private String name;

    private String code;

    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOOD_ID")
    private Food item;
}
