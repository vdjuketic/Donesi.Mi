package com.donesi.mi.userservice;

import com.donesi.mi.userservice.models.Order;
import com.donesi.mi.userservice.models.User;
import com.donesi.mi.userservice.repositories.UserRepository;
import com.donesi.mi.userservice.services.OrderInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

  private UserRepository userRepository;
  private OrderInfo orderInfo;

  @Autowired
  public UserResource(UserRepository userRepository, OrderInfo orderInfo) {
    this.userRepository = userRepository;
    this.orderInfo = orderInfo;
  }

  @RequestMapping("/list")
  public List<User> getListUsers() {
    return userRepository.getListUsers();
  }

  @RequestMapping("/{userId}")
  public User getUserById(@PathVariable("userId") int userId) {
    return userRepository.getUserById(userId);
  }

  @RequestMapping("/{userId}/orders")
  public Flux<Order> getOrdersOfUser(@PathVariable("userId") int userId)
          throws JsonProcessingException {

    // Get User with id
    User user = userRepository.getUserById(userId);

    // Get every order of user
    return HystrixCommands.from(orderInfo.getOrdersOfUserCall(user))
            .fallback(orderInfo.getOrdersOfUserFallback())
            .commandName("getOrdersOfUserCall")
            .toFlux();
  }
}
