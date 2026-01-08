package com.rasmoo.client.raspay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Dados para criação de um pedido")
public class OrderDto {

    @NotBlank(message = "customerId é obrigatório")
    @Schema(example = "cst_123456")
    private String customerId;

    @NotBlank(message = "productAcronym é obrigatório")
    @Schema(example = "PROD_XYZ")
    private String productAcronym;

    @PositiveOrZero(message = "discount não pode ser negativo")
    @Schema(example = "10.00", description = "Valor de desconto aplicado ao pedido")
    private BigDecimal discount;
}
