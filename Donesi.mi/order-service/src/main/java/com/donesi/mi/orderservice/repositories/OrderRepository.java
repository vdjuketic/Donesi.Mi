package com.donesi.mi.orderservice.repositories;

import com.donesi.mi.orderservice.models.Currency;
import com.donesi.mi.orderservice.models.Order;
import com.donesi.mi.orderservice.models.Payment;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class OrderRepository {

    public Order getOrderById(int id) {
        return new Order(1, new Date(), Arrays.asList(1, 2), new Payment(0, 100, Currency.EUR));
    }

    public List<Order> getOrderList() {
        return Arrays.asList(
                new Order(1, new Date(), Collections.singletonList(1), new Payment(0, 100, Currency.EUR)),
                new Order(2, new Date(), Collections.singletonList(2), new Payment(1, 300, Currency.EUR)));
    }
}
