package com.rasmoo.client.raspay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Dados do cartão de crédito para pagamento")
public class CreditCardDto {

    @NotBlank(message = "number é obrigatório")
    @Size(min = 16, max = 16, message = "Cartão inválido")
    @Schema(example = "4111111111111111")
    private String number;

    @NotBlank(message = "cvv é obrigatório")
    @Pattern(regexp = "\\d{3}", message = "cvv deve conter 3 números")
    @Schema(example = "123")
    private String cvv;

    @NotNull(message = "month é obrigatório")
    @Min(value = 1, message = "month não pode ser menor que 1")
    @Max(value = 12, message = "month não pode ser maior que 12")
    @Schema(example = "12")
    private Integer month;

    @NotNull(message = "year é obrigatório")
    @Min(value = 0, message = "year inválido")
    @Max(value = 99, message = "year inválido")
    @Schema(example = "28", description = "Ano no formato YY")
    private Integer year;

    @NotBlank(message = "documentNumber é obrigatório")
    @CPF(message = "CPF precisa ser válido")
    @Schema(example = "12345678909")
    private String documentNumber;

    @NotNull(message = "installments é obrigatório")
    @Positive(message = "installments deve ser maior que zero")
    @Schema(example = "1")
    private Integer installments;
}
