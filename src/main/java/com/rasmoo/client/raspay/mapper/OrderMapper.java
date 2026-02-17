package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.OrderModel;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper(){}

    public static OrderModel fromDtoToModel(OrderDto orderDto, ProductDto productDto) {
        return OrderModel.builder()
                // .id(orderDto.getId()) // REMOVE: id é gerado pelo Mongo
                .customerId(orderDto.getCustomerId())
                .originalPrice(productDto.getCurrentPrice())
                .discount(orderDto.getDiscount())
                .dtRegistedOrder(LocalDateTime.now())
                .product(productDto)
                .build();
    }
}
