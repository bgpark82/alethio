package com.alethio.service.domain.item.domain;

import com.alethio.service.domain.item.dto.ItemRequest;
import com.alethio.service.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private static final String FOOD_TYPE = "food";
    private static final String CLOTHES_TYPE = "clothes";

    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;

    public Item getItemByType(ItemRequest request) {
        switch(request.getItemType()) {
            case FOOD_TYPE:
                return foodRepository.findById(request.getId())
                        .orElseThrow(ItemNotFoundException::new);
            case CLOTHES_TYPE:
                return clothesRepository.findById(request.getId())
                        .orElseThrow(ItemNotFoundException::new);
            default:
                return null;
        }
    }
}
