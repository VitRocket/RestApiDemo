package com.github.vitrocket.restapidemo.order.inport;

import com.github.vitrocket.restapidemo.order.dto.OrderRequest;

public interface OrderCreator {

    String createOrder(OrderRequest order);

}
