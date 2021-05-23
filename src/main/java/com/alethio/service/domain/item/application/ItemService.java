package com.alethio.service.domain.item.application;

import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.item.domain.FoodRepository;
import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final FoodRepository foodRepository;

    public Food getItem(ItemRequest itemRequest) {
        final Food food = getFood(itemRequest);
        food.decreaseQuantity();
        return food;
    }

    private Food getFood(ItemRequest itemRequest) {
        return foodRepository.findById(itemRequest.getId())
                .orElseThrow(ItemNotFoundException::new);
    }
}
