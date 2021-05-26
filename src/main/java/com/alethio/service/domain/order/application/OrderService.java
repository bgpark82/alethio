package com.alethio.service.domain.order.application;

import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.order.dto.OrderResponse;


public interface OrderService {

    OrderResponse orderItem(OrderRequest request);

}
