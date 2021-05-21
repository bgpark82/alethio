package com.alethio.service.domain.order.dto;

import lombok.Getter;

@Getter
public class OrderRequest {

    private ContactInfo contactInfo;
    private Items items;

    @Getter
    static class ContactInfo {
        private String contactEmail;
        private String contactName;
        private String mobile;
    }

    @Getter
    static class Items {
        private String itemType;
        private Long id;
    }
}
