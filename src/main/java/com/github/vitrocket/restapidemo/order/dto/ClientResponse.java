package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ClientResponse {

        private String name;
        private String email;

}
