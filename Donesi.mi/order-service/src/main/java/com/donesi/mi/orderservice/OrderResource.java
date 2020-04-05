package com.donesi.mi.orderservice;

import com.donesi.mi.orderservice.models.Item;
import com.donesi.mi.orderservice.models.Order;
import com.donesi.mi.orderservice.models.Payment;
import com.donesi.mi.orderservice.repositories.OrderRepository;
import com.donesi.mi.orderservice.services.ItemInfo;
import com.donesi.mi.orderservice.services.PaymentInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderResource {

    private OrderRepository orderRepository;
    private PaymentInfo paymentInfo;
    private ItemInfo itemInfo;

    @Autowired
    public OrderResource(
            OrderRepository orderRepository,
            PaymentInfo paymentInfo,
            ItemInfo itemInfo) {
        this.orderRepository = orderRepository;
        this.paymentInfo = paymentInfo;
        this.itemInfo = itemInfo;
    }

    @RequestMapping("/list")
    public List<Order> getOrderList() {
        return orderRepository.getOrderList();
    }

    @RequestMapping("/{orderId}")
    public Order getOrderById(@PathVariable("orderId") int orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @RequestMapping("/{orderId}/items")
    public Flux<Item> getItemsOfOrder(@PathVariable("orderId") int orderId) throws JsonProcessingException {

        // Get order with id
        Order order = orderRepository.getOrderById(orderId);

        // Get every item in order
        return HystrixCommands.from(itemInfo.getItemsFromOrderCall(order))
                .fallback(itemInfo.getItemsFromOrderFallback())
                .commandName("getItemsFromOrderCall")
                .toFlux();
    }

    @RequestMapping("/{orderId}/payment")
    public Mono<Payment> getPaymentOfOrder(@PathVariable("orderId") int orderId) {
        // Get order with id
        Order order = orderRepository.getOrderById(orderId);

        // Get every payment in order
        return HystrixCommands.from(paymentInfo.getPaymentOfOrderCall(order))
                .fallback(paymentInfo.getPaymentOfOrderFallback())
                .commandName("getPaymentOfOrderCall")
                .toMono();
    }
}
