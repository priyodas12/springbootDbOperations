package tech.postgres.springbootDbOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tech.postgres.springbootDbOperations.service.OrderService;

@SpringBootApplication
public class SpringbootDbOperationsApplication {

  @Autowired
  private OrderService orderService;

  public static void main (String[] args) {
    SpringApplication.run (SpringbootDbOperationsApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase () {
    return args -> orderService.createBulkOrder ();

  }
}
