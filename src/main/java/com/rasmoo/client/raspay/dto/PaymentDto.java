package com.rasmoo.client.raspay.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    @NotBlank(message = "customerId é obrigatório")
    private String customerId;

    @NotBlank(message = "orderId é obrigatório")
    private String orderId;

    @NotNull(message = "creditCard é obrigatório")
    private CreditCardDto creditCard;
}
