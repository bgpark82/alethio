package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.item.dto.ItemRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderRequest {

    @JsonProperty("contactInfo")
    private OrderUserRequest userRequest;
    @JsonProperty("items")
    private ItemRequest itemRequest;
}
