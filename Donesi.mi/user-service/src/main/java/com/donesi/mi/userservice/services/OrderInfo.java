package com.donesi.mi.userservice.services;

import com.donesi.mi.userservice.models.Order;
import com.donesi.mi.userservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Collections;
import java.util.Date;

@Service
public class OrderInfo {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public OrderInfo(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<Order> getOrdersOfUserCall(User user) {
        return Flux.fromIterable(user.getOrders())
                .flatMap(
                        orderId ->
                                webClientBuilder
                                        .build()
                                        .get()
                                        .uri("http://order-service/order/{id}", orderId)
                                        .retrieve()
                                        .bodyToMono(Order.class))
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<Order> getOrdersOfUserFallback() {
        return Flux.just(new Order(0, new Date(), Collections.emptyList()));
    }
}
