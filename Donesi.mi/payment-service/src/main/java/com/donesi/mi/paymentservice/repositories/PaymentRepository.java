package com.donesi.mi.paymentservice.repositories;

import com.donesi.mi.paymentservice.models.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

  Configuration conf = new Configuration().configure().addAnnotatedClass(Payment.class);

  public Payment getPaymentById(int paymentId) {
    SessionFactory sessionFactory = conf.buildSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    Payment payment = session.get(Payment.class, paymentId);
    session.getTransaction().commit();
    return payment;
  }
}
