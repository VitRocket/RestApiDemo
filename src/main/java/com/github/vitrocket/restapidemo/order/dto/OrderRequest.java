package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class OrderRequest {

    private Long productId;
    private ClientRequest client;
    private String clientComment;

    public String getClientName() {
        return client == null ? null : client.getName();
    }

    public String getClientEmail() {
        return client == null ? null : client.getEmail();
    }
}
