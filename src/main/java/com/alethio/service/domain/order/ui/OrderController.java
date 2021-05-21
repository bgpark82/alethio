package com.alethio.service.domain.order.ui;

import com.alethio.service.domain.order.dto.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order")
    public ResponseEntity orderCloth(@RequestBody OrderRequest request) {
        System.out.println(request);
        return ResponseEntity.ok().build();
    }
}
