package com.github.vitrocket.restapidemo.order.service;

import com.github.vitrocket.restapidemo.order.dto.ClientUpdatePatch;
import com.github.vitrocket.restapidemo.order.dto.OrderUpdatePatch;
import com.github.vitrocket.restapidemo.order.inport.OrderUpdater;
import com.github.vitrocket.restapidemo.order.model.Client;
import com.github.vitrocket.restapidemo.order.model.Order;
import com.github.vitrocket.restapidemo.order.model.Product;
import com.github.vitrocket.restapidemo.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrderUpdateService implements OrderUpdater {

    private final OrderRepository orderRepository;

    @Override
    public void updateOrder(String id, OrderUpdatePatch newData) {
        Order order = orderRepository.get(id);
        if (order != null) {
            order = getUpdatedOrder(order, newData);
            orderRepository.save(order);
        }
    }

    private Order getUpdatedOrder(Order order, OrderUpdatePatch newData) {
        Order.OrderBuilder builder = Order.builder();

        builder.id(order.getId());

        if (newData.getProductId() != null) {
            builder.product(getProduct(newData.getProductIdData()));
        } else {
            builder.product(order.getProduct());
        }

        if (newData.getClient() != null) {
            builder.client(getClient(order.getClient(), newData.getClientData()));
        } else {
            builder.client(order.getClient());
        }

        if (newData.getClientComment() != null) {
            builder.clientComment(newData.getClientCommentData());
        } else {
            builder.clientComment(order.getClientComment());
        }
        return builder.build();
    }

    @Nullable
    private Product getProduct(@Nullable Long source) {
        if (source == null) {
            return null;
        } else {
            return Product.builder()
                    .id(source)
                    .name("Product Name " + source)
                    .build();
        }
    }

    @Nullable
    private Client getClient(Client old, @Nullable ClientUpdatePatch source) {
        if (source == null) {
            return null;
        } else {
            return Client.builder()
                    .name(source.getName() != null ? source.getNameData() : old.getName())
                    .email(source.getEmail() != null ? source.getEmailData() : old.getEmail())
                    .build();
        }
    }
}
