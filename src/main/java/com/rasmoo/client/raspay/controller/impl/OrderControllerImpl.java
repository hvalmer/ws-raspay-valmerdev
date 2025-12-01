package com.rasmoo.client.raspay.controller.impl;

import com.rasmoo.client.raspay.controller.OrderController;
import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.OrderModel;
import com.rasmoo.client.raspay.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;


    public OrderControllerImpl(OrderService orderService){

        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto, Object content){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.create(orderDto));
    }
}
