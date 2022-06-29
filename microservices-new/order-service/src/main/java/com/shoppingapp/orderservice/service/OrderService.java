package com.shoppingapp.orderservice.service;

import com.shoppingapp.orderservice.model.entity.Order;
import com.shoppingapp.orderservice.model.entity.OrderLineItems;
import com.shoppingapp.orderservice.model.request.OrderLineItemsRequest;
import com.shoppingapp.orderservice.model.request.OrderRequest;
import com.shoppingapp.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems =  orderRequest.getOrderLineItemsRequestList().stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }

    // To Entity:
    private OrderLineItems toEntity(OrderLineItemsRequest i) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(i.getPrice());
        orderLineItems.setQuantity(i.getQuantity());
        orderLineItems.setSkuCode(i.getSkuCode());
        return orderLineItems;
    }

}
