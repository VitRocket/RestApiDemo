package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class OrderResponse {

    private String id;
    private ProductResponse product;
    private ClientResponse client;
    private String clientComment;

}
