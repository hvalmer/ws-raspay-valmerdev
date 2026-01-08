package com.rasmoo.client.raspay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados para cadastro de produto")
public class ProductDto {

    @NotBlank(message = "acronym é obrigatório")
    @Size(min = 6, max = 20)
    @Schema(example = "PROD_ABC123")
    private String acronym;

    @NotBlank(message = "name é obrigatório")
    @Schema(example = "Produto Premium")
    private String name;

    @Positive(message = "currentPrice deve ser maior que zero")
    @Schema(example = "199.90")
    private BigDecimal currentPrice;
}
