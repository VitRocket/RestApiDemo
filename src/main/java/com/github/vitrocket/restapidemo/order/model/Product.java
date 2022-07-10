package com.github.vitrocket.restapidemo.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Product {

    private Long id;
    private String name;

}
