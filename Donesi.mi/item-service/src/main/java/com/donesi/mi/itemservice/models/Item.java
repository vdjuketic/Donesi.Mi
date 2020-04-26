package com.donesi.mi.itemservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicUpdate
@Entity(name = "items")
public class Item {

  @Id @GeneratedValue int id;

  @Column String store;

  @Column String name;

  @Column String description;
}
