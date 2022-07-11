package com.github.vitrocket.restapidemo.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Order {

    private String id;
    private Product product;
    private Client client;
    private String clientComment;

    public Long getProductId() {
        return product == null ? null : product.getId();
    }

    public String getProductName() {
        return product == null ? null : product.getName();
    }

    public String getClientName() {
        return client == null ? null : client.getName();
    }

    public String getClientEmail() {
        return client == null ? null : client.getEmail();
    }
}
