package com.alethio.service.domain.stock.application;

import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.stock.domain.StockRequest;
import com.alethio.service.domain.stock.domain.StockRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockRequestService {

    private final StockRequestRepository stockRequestRepository;

    public void requestStock(Food food) {
        if(food.hasShortStock()) {
            stockRequestRepository.save(StockRequest.create(food.getName()));
        }
    }
}
