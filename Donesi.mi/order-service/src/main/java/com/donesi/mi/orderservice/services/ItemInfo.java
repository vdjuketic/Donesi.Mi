package com.donesi.mi.orderservice.services;

import com.donesi.mi.orderservice.models.Item;
import com.donesi.mi.orderservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class ItemInfo {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public ItemInfo(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<Item> getItemsFromOrderCall(Order order) {
        return Flux.fromIterable(order.getItems())
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
