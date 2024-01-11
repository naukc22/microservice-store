package ru.naukc.orderservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.naukc.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
