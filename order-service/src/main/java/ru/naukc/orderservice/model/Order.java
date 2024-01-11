package ru.naukc.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "t_orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;     // список позиций в заказе
}

