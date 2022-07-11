package com.github.vitrocket.restapidemo.order.repository;

import com.github.vitrocket.restapidemo.order.model.Client;
import com.github.vitrocket.restapidemo.order.model.Order;
import com.github.vitrocket.restapidemo.order.model.Product;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderRepository {

    private final Map<String, Order> orders = new HashMap<>();

    {
        orders.put("039a7289-52de-47e3-b155-68781413a0a1",
                Order.builder()
                        .id("039a7289-52de-47e3-b155-68781413a0a1")
                        .product(Product.builder()
                                .id(100L)
                                .name("First Java Book")
                                .build())
                        .client(Client.builder()
                                .name("Hryhorii Skovoroda")
                                .email("Hryhorii.Skovoroda@example.com")
                                .build())
                        .clientComment("You can be careful, please.")
                        .build());
    }

    public void save(Order newOrder) {
        orders.put(newOrder.getId(), newOrder);
    }

    @Nullable
    public Order get(String id) {
        return orders.getOrDefault(id, null);
    }


    public List<Order> get() {
        return orders.values().stream().toList();
    }
}
