package com.alethio.service.domain.item.domain;

public interface ItemFactory {

    Item findItemByType(Long id, String type);
}
