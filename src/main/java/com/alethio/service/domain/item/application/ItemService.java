package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.item.dto.ItemRequest;

public interface ItemService {

    Item getItem(ItemRequest request);
}
