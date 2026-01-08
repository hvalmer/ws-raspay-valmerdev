package com.rasmoo.client.raspay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para processamento de pagamento")
public class PaymentDto {

    @NotBlank(message = "customerId é obrigatório")
    @Schema(example = "cst_123456")
    private String customerId;

    @NotBlank(message = "orderId é obrigatório")
    @Schema(example = "ord_987654")
    private String orderId;

    @NotNull(message = "creditCard é obrigatório")
    private CreditCardDto creditCard;
}
