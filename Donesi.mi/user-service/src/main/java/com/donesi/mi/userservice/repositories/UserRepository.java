package com.donesi.mi.userservice.repositories;

import com.donesi.mi.userservice.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    Configuration conf = new Configuration().configure().addAnnotatedClass(User.class);

    public List<User> getListUsers() {
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<User> users = session.createQuery("from users", User.class).list();
        session.getTransaction().commit();

        return users;
    }

    public User getUserById(int userId) {
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = session.get(User.class, userId);
        session.getTransaction().commit();

        return user;
    }
}
