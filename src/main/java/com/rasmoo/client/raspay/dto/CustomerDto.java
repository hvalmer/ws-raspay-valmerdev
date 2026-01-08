package com.rasmoo.client.raspay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados necessários para criação de um cliente")
public class CustomerDto {

    @NotBlank(message = "firstName é obrigatório")
    @Schema(example = "João")
    private String firstName;

    @NotBlank(message = "lastName é obrigatório")
    @Schema(example = "Silva")
    private String lastName;

    @NotBlank(message = "email é obrigatório")
    @Email(message = "email precisa ser válido")
    @Schema(example = "joao.silva@email.com")
    private String email;

    @NotBlank(message = "cpf deve ser preenchido")
    @CPF(message = "cpf precisa ser válido")
    @Schema(example = "12345678909")
    private String cpf;
}
