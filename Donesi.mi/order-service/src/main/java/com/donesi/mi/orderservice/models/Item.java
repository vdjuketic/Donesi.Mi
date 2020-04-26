package com.donesi.mi.orderservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

  int id;

  String store;

  String name;

  String description;

  public Item(String name) {
    this.name = name;
  }
}
