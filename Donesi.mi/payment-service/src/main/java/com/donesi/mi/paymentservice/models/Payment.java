package com.donesi.mi.paymentservice.models;

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
