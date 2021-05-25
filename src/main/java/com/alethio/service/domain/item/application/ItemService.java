package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.ClothesRepository;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;

    public Item getItem(ItemRequest request) {
        final Item item = getItemByType(request);
        item.decreaseQuantity();
        return item;
    }

    private Item getItemByType(ItemRequest request) {
        if(request.getItemType().equals("food")) {
            return foodRepository.findById(request.getId())
                    .orElseThrow(ItemNotFoundException::new);
        }
        if(request.getItemType().equals("clothes")) {
            return clothesRepository.findById(request.getId())
                    .orElseThrow(ItemNotFoundException::new);
        }
        return null;
    }
}
