package com.alethio.service.domain.order.application;

import com.alethio.service.domain.item.application.ItemService;
import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.stock.application.StockRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemService itemService;
    private final StockRequestService stockRequestService;

    public Food orderItem(OrderRequest request) {
        Food food = itemService.getItem(request.getItemRequest());
        stockRequestService.requestStock(food);
        return food;
    }
}
