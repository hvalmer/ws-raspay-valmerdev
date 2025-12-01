package com.rasmoo.client.raspay.controller.impl;

import com.rasmoo.client.raspay.controller.PaymentController;
import com.rasmoo.client.raspay.dto.PaymentDto;
import com.rasmoo.client.raspay.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payments")
public class PaymentControllerImpl implements PaymentController {

    private final PaymentService paymentService;

    @Autowired
    PaymentControllerImpl(PaymentService paymentService){

        this.paymentService = paymentService;
    }

    @Override
    public ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto){
        return ResponseEntity.ok(paymentService.process(dto));
    }

}
