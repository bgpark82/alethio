package com.alethio.service.domain.order.application;

import com.alethio.service.domain.item.application.ItemService;
import com.alethio.service.domain.item.domain.Item;
import com.alethio.service.domain.item.dto.ItemRequest;
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
public class OrderServiceImpl implements OrderService{

    private final ItemService itemService;
    private final StockRequestService stockRequestService;
    private final OrderRepository orderRepository;

    @Override
    public OrderResponse orderItem(OrderRequest request) {
        final ItemRequest itemRequest = request.getItemRequest();
        final OrderUserRequest userRequest = request.getUserRequest();
        final Item item = itemService.getItem(itemRequest);

        if(item.hasShortStock()) {
            stockRequestService.requestStock(item.getName(), itemRequest.getItemType());
        }

        final Order order = Order.create(
                createOrderUser(userRequest),
                createOrderItem(item));

        orderRepository.save(order);

        return OrderResponse.of(order);
    }

    private OrderUser createOrderUser(OrderUserRequest userRequest) {
        return OrderUser.create(
                userRequest.getContactName(),
                userRequest.getContactEmail(),
                userRequest.getMobile());
    }

    private OrderItem createOrderItem(Item item) {
        return OrderItem.create(
                item.getId(),
                item.getName(),
                item.getQuantity());
    }
}
