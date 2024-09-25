package tech.postgres.springbootDbOperations.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.postgres.springbootDbOperations.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}