package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class OrderUpdatePatch {

    private Optional<Long> productId;
    private Optional<ClientUpdatePatch> client;
    private Optional<String> clientComment;

    public String getClientName() {
        return client.map(ClientUpdatePatch::getName).flatMap(s -> s).orElse(null);
    }

    public String getClientEmail() {
        return client.map(ClientUpdatePatch::getEmail).flatMap(s -> s).orElse(null);
    }

    public boolean isPresentProductId() {
        return productId.isPresent();
    }

    public Long getProductIdData() {
        return productId.orElse(null);
    }

    public boolean isPresentClient() {
        return client.isPresent();
    }

    public ClientUpdatePatch getClientData() {
        return client.orElse(null);
    }

    public boolean isPresentClientComment() {
        return clientComment.isPresent();
    }

    public String getClientCommentData() {
        return clientComment.orElse(null);
    }
}
