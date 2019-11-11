package com.donesi.mi.itemservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Item {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String store;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;
}
