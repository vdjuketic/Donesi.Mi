package com.donesi.mi.orderservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Payment {
    @Getter
    @Setter
    int id;
    @Getter
    @Setter
    int amount;
    @Getter
    @Setter
    Currency currency;
}
