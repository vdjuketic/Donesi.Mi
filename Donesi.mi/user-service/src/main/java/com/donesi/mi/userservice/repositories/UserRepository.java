package com.donesi.mi.userservice.repositories;

import com.donesi.mi.userservice.models.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> getListUsers() {
        return Collections.singletonList(new User(1, "Vukasin", "Djuketic", List.of()));
    }

    public User getUserById(int userId) {
        return new User(1, "Vukasin", "Djuketic", List.of());
    }
}
