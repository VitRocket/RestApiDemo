package com.github.vitrocket.restapidemo.order.service;

import com.github.vitrocket.restapidemo.order.dto.ClientResponse;
import com.github.vitrocket.restapidemo.order.dto.OrderRequest;
import com.github.vitrocket.restapidemo.order.dto.OrderResponse;
import com.github.vitrocket.restapidemo.order.dto.ProductResponse;
import com.github.vitrocket.restapidemo.order.inport.OrderCreator;
import com.github.vitrocket.restapidemo.order.inport.OrderGetter;
import com.github.vitrocket.restapidemo.order.model.Client;
import com.github.vitrocket.restapidemo.order.model.Order;
import com.github.vitrocket.restapidemo.order.model.Product;
import com.github.vitrocket.restapidemo.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class OrderService implements OrderCreator, OrderGetter {

    private final OrderRepository orderRepository;

    @Override
    public String createOrder(OrderRequest order) {
        Order newOrder = Order.builder()
                .id(UUID.randomUUID().toString())
                .product(Product.builder()
                        .id(order.getProductId())
                        .build())
                .client(Client.builder()
                        .name(order.getClientName())
                        .email(order.getClientEmail())
                        .build())
                .clientComment(order.getClientComment())
                .build();
        orderRepository.save(newOrder);
        return newOrder.getId();
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.get().stream()
                .map(this::getOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrder(String id) {
        return getOrderResponse(orderRepository.get(id));
    }

    private OrderResponse getOrderResponse(Order order) {
        if (order == null) {
            return null;
        }
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
