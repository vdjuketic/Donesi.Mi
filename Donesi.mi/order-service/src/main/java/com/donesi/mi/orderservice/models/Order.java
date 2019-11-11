package com.donesi.mi.orderservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class Order {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private Date orderDate;

    @Getter
    @Setter
    private List<Integer> items;

    @Getter
    @Setter
    private Payment payment;
}
