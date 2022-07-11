package com.github.vitrocket.restapidemo.order.api;

import com.github.vitrocket.restapidemo.order.dto.OrderRequest;
import com.github.vitrocket.restapidemo.order.dto.OrderResponse;
import com.github.vitrocket.restapidemo.order.dto.OrderUpdatePatch;
import com.github.vitrocket.restapidemo.order.inport.OrderCreator;
import com.github.vitrocket.restapidemo.order.inport.OrderGetter;
import com.github.vitrocket.restapidemo.order.inport.OrderUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderGetter orderGetter;
    private final OrderCreator orderCreator;
    private final OrderUpdater orderUpdater;

    @GetMapping
    List<OrderResponse> getOrder() {
        return orderGetter.getOrders();
    }

    @GetMapping(value = "/{id}")
    public OrderResponse findById(@PathVariable("id") String id) {
        return orderGetter.getOrder(id);
    }

    @PostMapping
    ResponseEntity<Object> createOrder(@RequestBody OrderRequest newOrder) {
        String id = orderCreator.createOrder(newOrder);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping(value = "/{id}")
    ResponseEntity<Object> updateOrder(@PathVariable("id") String id, @RequestBody OrderUpdatePatch update) {

        orderUpdater.updateOrder(id, update);

        return ResponseEntity.noContent().build();
    }

}
