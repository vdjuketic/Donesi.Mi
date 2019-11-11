package com.donesi.mi.paymentservice.repositories;

import com.donesi.mi.paymentservice.models.Currency;
import com.donesi.mi.paymentservice.models.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    public Payment getPaymentById(int paymentId) {
        return new Payment(0, 100, Currency.EUR);
    }
}
