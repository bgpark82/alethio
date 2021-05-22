package com.alethio.service.domain.order.application;

import com.alethio.service.domain.item.application.ItemService;
import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemService itemService;

    public Food orderItem(OrderRequest request) {
        return itemService.getItem(request.getItemRequest());
    }
}
