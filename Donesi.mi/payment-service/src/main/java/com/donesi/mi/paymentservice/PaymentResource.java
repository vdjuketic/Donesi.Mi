package com.donesi.mi.paymentservice;

import com.donesi.mi.paymentservice.models.Payment;
import com.donesi.mi.paymentservice.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

  private PaymentRepository paymentRepository;

  @Autowired
  public PaymentResource(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  @RequestMapping("/{paymentId}")
  public Payment getPaymentById(@PathVariable("paymentId") int paymentId) {
    return paymentRepository.getPaymentById(paymentId);
  }
}
