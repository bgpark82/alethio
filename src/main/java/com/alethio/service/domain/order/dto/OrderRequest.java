package com.alethio.service.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
public class OrderRequest {

    private ContactInfo contactInfo;
    private Items items;

    OrderRequest(String contactEmail, String contactName, String mobile, String itemType, int id) {
        this.contactInfo = new ContactInfo(contactEmail, contactName, mobile);
        this.items = new Items(itemType, id);
    }

    @Getter
    @NoArgsConstructor(access = PRIVATE)
    @AllArgsConstructor(access = PRIVATE)
    static class ContactInfo {
        private String contactEmail;
        private String contactName;
        private String mobile;
    }

    @Getter
    @NoArgsConstructor(access = PRIVATE)
    @AllArgsConstructor(access = PRIVATE)
    static class Items {
        private String itemType;
        private int id;
    }
}
