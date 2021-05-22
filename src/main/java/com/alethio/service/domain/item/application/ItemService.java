package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemService {

    private final FoodRepository foodRepository;

    public Food getItem(ItemRequest itemRequest) {
        return foodRepository.findById(itemRequest.getId())
                .orElseThrow(ItemNotFoundException::new);
    }
}
