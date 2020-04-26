package com.donesi.mi.orderservice.services;

import com.donesi.mi.orderservice.models.Currency;
import com.donesi.mi.orderservice.models.Order;
import com.donesi.mi.orderservice.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentInfo {

  private WebClient.Builder webClientBuilder;

  @Autowired
  public PaymentInfo(WebClient.Builder webClientBuilder) {
    this.webClientBuilder = webClientBuilder;
  }

  public Mono<Payment> getPaymentOfOrderCall(Order order) {
    return webClientBuilder
        .build()
        .get()
        .uri("http://payment-service/payment/{id}", order.getPayment())
        .retrieve()
        .bodyToMono(Payment.class);
  }

  public Mono<Payment> getPaymentOfOrderFallback() {
    return Mono.just(new Payment(0, 0.0, Currency.EUR));
  }
}
