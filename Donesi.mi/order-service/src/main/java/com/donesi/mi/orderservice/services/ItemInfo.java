package com.donesi.mi.orderservice.services;

import com.donesi.mi.orderservice.models.Item;
import com.donesi.mi.orderservice.models.Order;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class ItemInfo {

    private WebClient.Builder webClientBuilder;
    private ObjectMapper objectMapper;

    @Autowired
    public ItemInfo(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClientBuilder = webClientBuilder;
        this.objectMapper = objectMapper;
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public Flux<Item> getItemsFromOrderCall(Order order) throws JsonProcessingException {

        List<Integer> itemIDs = objectMapper.readValue(order.getItems(), List.class);

        return Flux.fromIterable(itemIDs)
                .flatMap(
                        itemId ->
                                webClientBuilder
                                        .build()
                                        .get()
                                        .uri("http://item-service/item/{id}", itemId)
                                        .retrieve()
                                        .bodyToMono(Item.class))
                .subscribeOn(Schedulers.parallel());
    }

    public Flux<Item> getItemsFromOrderFallback() {
        return Flux.just(new Item("Item not found"));
    }
}
