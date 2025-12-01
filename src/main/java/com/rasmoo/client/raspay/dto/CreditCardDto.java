package com.rasmoo.client.raspay.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto {

    @NotBlank(message = "number é obrigatório")
    @Size(min = 16,max = 16,message = "Cartão inválido")
    private String number;

    @Size(min = 3,max = 3,message = "cvv deve conter 3 números")
    private Long cvv;

    @Min(value = 1,message = "month não pode ser menor que 1")
    @Max(value = 2,message = "month não pode ser maior que 12")
    private Long month;

    @Size(min = 2,max = 2,message = "year deve conter 2 números")
    private Long year;

    @CPF(message = "CPF precisa ser válido")
    private String documentNumber;

    private Long installments;

}
