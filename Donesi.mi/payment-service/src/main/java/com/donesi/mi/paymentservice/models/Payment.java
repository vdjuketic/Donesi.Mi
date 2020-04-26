package com.donesi.mi.paymentservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
@Entity(name = "payment")
public class Payment {

  @Id @GeneratedValue int id;

  @Column Double amount;

  @Column
  @Enumerated(EnumType.STRING)
  Currency currency;
}
