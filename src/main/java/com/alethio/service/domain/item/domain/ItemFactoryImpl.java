package com.alethio.service.domain.item.domain;

import com.alethio.service.domain.item.domain.clothes.ClothesRepository;
import com.alethio.service.domain.item.domain.food.FoodRepository;
import com.alethio.service.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemFactoryImpl implements ItemFactory {

    private static final String FOOD_TYPE = "food";
    private static final String CLOTHES_TYPE = "clothes";

    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;

    @Override
    public Item findItemByType(Long id, String type) {
        switch(type) {
            case FOOD_TYPE:
                return foodRepository.findById(id)
                        .orElseThrow(ItemNotFoundException::new);
            case CLOTHES_TYPE:
                return clothesRepository.findById(id)
                        .orElseThrow(ItemNotFoundException::new);
            default:
                return null;
        }
    }
}
