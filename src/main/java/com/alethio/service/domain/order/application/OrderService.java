package com.alethio.service.domain.order.application;

import com.alethio.service.domain.item.application.ItemService;
import com.alethio.service.domain.item.domain.Food;
import com.alethio.service.domain.order.domain.Order;
import com.alethio.service.domain.order.domain.OrderItem;
import com.alethio.service.domain.order.domain.OrderRepository;
import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.order.dto.OrderResponse;
import com.alethio.service.domain.stock.application.StockRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final ItemService itemService;
    private final StockRequestService stockRequestService;
    private final OrderRepository orderRepository;

    public OrderResponse orderItem(OrderRequest request) {
        final Food food = itemService.getItem(request.getItemRequest());
        stockRequestService.requestStock(food);

        final OrderItem orderItem = OrderItem.create(
                food.getId(),
                food.getName(),
                food.getQuantity());

        final Order order = Order.create(
                request.getContactEmail(),
                orderItem);

        orderRepository.save(order);

        return OrderResponse.of(order);
    }
}
