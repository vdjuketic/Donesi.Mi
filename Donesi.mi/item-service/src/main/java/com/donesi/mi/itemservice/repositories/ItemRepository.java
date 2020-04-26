package com.donesi.mi.itemservice.repositories;

import com.donesi.mi.itemservice.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    Configuration conf = new Configuration().configure().addAnnotatedClass(Item.class);

    public List<Item> getItemList() {
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Item> items = session.createQuery("from items", Item.class).list();
        session.getTransaction().commit();

        return items;
    }

    public Item getItemById(int itemId) {
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Item item = session.get(Item.class, itemId);
        session.getTransaction().commit();
        return item;
    }
}
