package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Item;

public interface ItemFactory {

    Item findItemByType(Long id, String type);
}
