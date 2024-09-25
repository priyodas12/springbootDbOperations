package tech.postgres.springbootDbOperations.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import jakarta.transaction.Transactional;
import tech.postgres.springbootDbOperations.dao.OrderRepository;
import tech.postgres.springbootDbOperations.model.Order;
import tech.postgres.springbootDbOperations.model.OrderItem;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private Faker faker;

  public List<Order> getAllOrders () {
    return orderRepository.findAll ();
  }

  public Optional<Order> getOrderById (Long id) {
    return orderRepository.findById (id);
  }

  public Order saveOrder (Order order) {
    return orderRepository.save (order);
  }

  public void deleteOrder (Long id) {
    orderRepository.deleteById (id);
  }

  public void createBulkOrder () {
    for (int i = 0; i < 100; i++) {
      var order = createRandomOrder ();
      orderRepository.save (order);
    }
  }

  @Transactional
  public Order createRandomOrder () {
    // Create a new Order
    Order order = new Order ();
    order.setOrderDate (LocalDateTime.now ());
    order.setCustomerName (faker.name ().fullName ());

    // Create OrderItems
    List<OrderItem> items = new ArrayList<> ();
    for (int i = 0; i < faker.number ().numberBetween (1, 10); i++) {
      OrderItem item = new OrderItem ();
      item.setProductName (faker.commerce ().productName ());
      item.setQuantity (faker.number ().numberBetween (1, 15420));
      item.setPrice (BigDecimal.valueOf (faker.number ().randomDouble (4, 10, 22200)));
      item.setOrder (order); // Link item to the order
      items.add (item);
    }

    // Set items to the order
    order.setItems (items);

    // Save the order (which will also save the items due to cascading)
    return orderRepository.save (order);
  }
}

