package com.alethio.service.domain.stock.application;

import com.alethio.service.domain.stock.domain.StockRequest;
import com.alethio.service.domain.stock.domain.StockRequestRepository;
import com.alethio.service.domain.stock.domain.StockType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockRequestServiceImpl implements StockRequestService{

    private final StockRequestRepository stockRequestRepository;

    @Override
    public void requestStock(String itemName, String itemType) {
        final String code = getCode(itemName, itemType);
        stockRequestRepository.save(StockRequest.create(itemName, code));
    }

    private String getCode(String itemName, String itemType) {
        return StockType
                .valueOf(itemType)
                .getCode(itemName);
    }
}
