package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class OrderResponse {

    private UUID id;
    private ProductResponse product;
    private ClientResponse client;
    private String clientComment;

}
