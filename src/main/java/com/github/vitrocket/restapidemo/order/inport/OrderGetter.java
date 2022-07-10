package com.github.vitrocket.restapidemo.order.inport;

import com.github.vitrocket.restapidemo.order.dto.OrderResponse;

import java.util.List;

public interface OrderGetter {

    List<OrderResponse> getOrders();

    OrderResponse getOrder(String id);

}
