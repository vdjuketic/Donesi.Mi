package com.donesi.mi.userservice.services;

import com.donesi.mi.userservice.models.Currency;
import com.donesi.mi.userservice.models.Order;
import com.donesi.mi.userservice.models.Payment;
import com.donesi.mi.userservice.models.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfo {

    private WebClient.Builder webClientBuilder;
    private ObjectMapper objectMapper;

    @Autowired
    public OrderInfo(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClientBuilder = webClientBuilder;
        this.objectMapper = objectMapper;
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public Flux<Order> getOrdersOfUserCall(User user) throws JsonProcessingException {

        List<Integer> orderIds = objectMapper.readValue(user.getOrders(), List.class);

        return Flux.fromIterable(orderIds)
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
        return Flux.just(new Order(0, new Date(), Collections.emptyList(), new Payment(0, 0, Currency.EUR)));
    }
}
