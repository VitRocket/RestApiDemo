package com.github.vitrocket.restapidemo.order.service;

import com.github.vitrocket.restapidemo.order.dto.ClientResponse;
import com.github.vitrocket.restapidemo.order.dto.OrderRequest;
import com.github.vitrocket.restapidemo.order.dto.OrderResponse;
import com.github.vitrocket.restapidemo.order.dto.ProductResponse;
import com.github.vitrocket.restapidemo.order.inport.OrderUpdater;
import com.github.vitrocket.restapidemo.order.model.Client;
import com.github.vitrocket.restapidemo.order.model.Product;
import com.github.vitrocket.restapidemo.order.inport.OrderCreator;
import com.github.vitrocket.restapidemo.order.inport.OrderGetter;
import com.github.vitrocket.restapidemo.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
class OrderService implements OrderCreator, OrderGetter, OrderUpdater {

    private List<Order> orders;

    {
        orders = new ArrayList<>();
    }

    @Override
    public UUID createOrder(OrderRequest order) {
        Order newOrder = Order.builder()
                .id(UUID.randomUUID())
                .product(Product.builder()
                        .id(order.getProductId())
                        .build())
                .client(Client.builder()
                        .name(order.getClientName())
                        .email(order.getClientEmail())
                        .build())
                .clientComment(order.getClientComment())
                .build();
        orders.add(newOrder);
        return newOrder.getId();
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orders.stream()
                .map(this::getOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrder(String id) {
        return orders.stream()
                .filter(order -> order.getId().toString().equals(id))
                .findAny()
                .map(this::getOrderResponse)
                .orElse(null);
    }

    @Override
    public void updateOrder(OrderRequest order) {
//TODO
    }

    private OrderResponse getOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .product(ProductResponse.builder()
                        .id(order.getProductId())
                        .name(order.getProductName())
                        .build())
                .client(ClientResponse.builder()
                        .name(order.getClientName())
                        .email(order.getClientEmail())
                        .build())
                .clientComment(order.getClientComment())
                .build();
    }
}
