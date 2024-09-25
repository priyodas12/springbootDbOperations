package tech.postgres.springbootDbOperations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.log4j.Log4j2;
import tech.postgres.springbootDbOperations.model.Order;
import tech.postgres.springbootDbOperations.service.OrderService;

@Log4j2
@RestController
@RequestMapping ("/api/resource/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping
  public List<Order> getAllOrders () {
    return orderService.getAllOrders ();
  }

  @GetMapping ("/{id}")
  public Optional<Order> getOrderById (@PathVariable Long id) {
    return orderService.getOrderById (id);
  }

  @PostMapping
  public Order createOrder (@RequestBody Order order) {
    return orderService.saveOrder (order);
  }

  @DeleteMapping ("/{id}")
  public void deleteOrder (@PathVariable Long id) {
    orderService.deleteOrder (id);
  }
}
