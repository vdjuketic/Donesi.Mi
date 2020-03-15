package com.donesi.mi.orderservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;

    private Date orderDate;

    private List<Integer> items;

    private Payment payment;
}
