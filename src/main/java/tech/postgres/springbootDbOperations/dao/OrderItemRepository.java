package tech.postgres.springbootDbOperations.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.postgres.springbootDbOperations.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
