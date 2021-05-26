package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.item.domain.ItemFactory;
import com.alethio.service.domain.item.dto.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemFactory itemFactory;

    public Item getItem(ItemRequest request) {
        final Item item = findItemByType(request);
        item.decreaseQuantity();
        return item;
    }

    private Item findItemByType(ItemRequest request) {
        return itemFactory.findItemByType(
                request.getId(),
                request.getItemType());
    }
}
