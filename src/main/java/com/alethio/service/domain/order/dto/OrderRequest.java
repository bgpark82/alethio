package com.alethio.service.domain.order.dto;

import com.alethio.service.domain.item.dto.ItemRequest;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderRequest {

    private ContactInfo contactInfo;
    @JsonProperty("items")
    private ItemRequest itemRequest;

    public String getContactEmail() {
        return this.contactInfo.getContactEmail();
    }

    @Getter
    public static class ContactInfo {
        private String contactEmail;
        private String contactName;
        private String mobile;
    }
}
