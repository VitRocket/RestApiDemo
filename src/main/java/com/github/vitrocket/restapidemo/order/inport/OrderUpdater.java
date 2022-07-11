package com.github.vitrocket.restapidemo.order.inport;

import com.github.vitrocket.restapidemo.order.dto.OrderUpdatePatch;

public interface OrderUpdater {

    void updateOrder(String id, OrderUpdatePatch order);

}
