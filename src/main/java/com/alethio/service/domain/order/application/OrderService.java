package com.alethio.service.domain.order.application;

import com.alethio.service.domain.item.application.ItemService;
import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.order.domain.Order;
import com.alethio.service.domain.order.domain.OrderItem;
import com.alethio.service.domain.order.domain.OrderRepository;
import com.alethio.service.domain.order.domain.OrderUser;
import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.order.dto.OrderResponse;
import com.alethio.service.domain.order.dto.OrderUserRequest;
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
        final Item item = itemService.getItem(request.getItemRequest());
        stockRequestService.requestStock(item);

        final OrderItem orderItem = OrderItem.create(
                item.getId(),
                item.getName(),
                item.getQuantity());

        final OrderUserRequest userRequest = request.getUserRequest();
        final OrderUser orderUser = OrderUser.create(
                userRequest.getContactName(),
                userRequest.getContactEmail(),
                userRequest.getMobile());

        final Order order = Order.create(
                orderUser,
                orderItem);

        orderRepository.save(order);

        return OrderResponse.of(order);
    }
}
