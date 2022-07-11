package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;
import org.springframework.lang.Nullable;

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

    @Nullable
    public Long getProductIdData() {
        return productId.orElse(null);
    }

    @Nullable
    public ClientUpdatePatch getClientData() {
        return client.orElse(null);
    }

    @Nullable
    public String getClientCommentData() {
        return clientComment.orElse(null);
    }
}
