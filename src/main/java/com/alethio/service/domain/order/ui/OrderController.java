package com.alethio.service.domain.order.ui;

import com.alethio.service.domain.order.application.OrderService;
import com.alethio.service.domain.order.dto.OrderRequest;
import com.alethio.service.domain.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity orderClothes(@RequestBody OrderRequest request) {
        final OrderResponse response = orderService.orderItem(request);
        return ResponseEntity.ok().body(response);
    }
}
