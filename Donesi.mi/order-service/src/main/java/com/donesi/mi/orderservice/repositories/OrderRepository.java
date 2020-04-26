package com.donesi.mi.orderservice.repositories;

import com.donesi.mi.orderservice.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

  Configuration conf = new Configuration().configure().addAnnotatedClass(Order.class);

  public Order getOrderById(int orderId) {
    SessionFactory sessionFactory = conf.buildSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    Order order = session.get(Order.class, orderId);
    session.getTransaction().commit();
    return order;
  }

  public List<Order> getOrderList() {
    SessionFactory sessionFactory = conf.buildSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    List<Order> orders = session.createQuery("from orders", Order.class).list();
    session.getTransaction().commit();

    return orders;
  }
}
