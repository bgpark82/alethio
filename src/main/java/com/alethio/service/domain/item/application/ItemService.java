package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.item.domain.ItemRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item getItem(ItemRequest request) {
        final Item item = itemRepository.getItemByType(request);
        item.decreaseQuantity();
        return item;
    }
}
