package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ProductResponse {

    private Long id;
    private String name;

}
