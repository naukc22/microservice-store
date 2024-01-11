package ru.naukc.orderservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.naukc.orderservice.dto.OrderRequest;
import ru.naukc.orderservice.service.OrderService;


@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class  OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Your order has been created!";
    }

}
