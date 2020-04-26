package com.donesi.mi.orderservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicUpdate
@Entity(name = "orders")
public class Order {

  @Id @GeneratedValue int id;

  @Column(name = "order_date")
  Date orderDate;

  @Column String items;

  @Column int payment;
}
