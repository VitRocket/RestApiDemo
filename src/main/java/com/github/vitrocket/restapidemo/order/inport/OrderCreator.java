package com.github.vitrocket.restapidemo.order.inport;

import com.github.vitrocket.restapidemo.order.dto.OrderRequest;

import java.util.UUID;

public interface OrderCreator {

    UUID createOrder(OrderRequest order);

}
