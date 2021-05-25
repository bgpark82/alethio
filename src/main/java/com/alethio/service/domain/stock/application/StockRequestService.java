package com.alethio.service.domain.stock.application;

import com.alethio.service.domain.stock.domain.StockRequest;
import com.alethio.service.domain.stock.domain.StockRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockRequestService {

    private final StockRequestRepository stockRequestRepository;

    public void requestStock(String itemName, String itemType) {
        stockRequestRepository.save(StockRequest.create(itemName, itemType));
    }
}
