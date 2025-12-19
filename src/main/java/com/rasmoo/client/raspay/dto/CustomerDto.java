package com.rasmoo.client.raspay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String id;

    @NotBlank(message = "firstName é obrigatório")
    private String firstName;

    @NotBlank(message = "lastName é obrigatório")
    private String lastName;

    @Email(message = "email precisa ser válido")
    private String email;

    @NotBlank(message = "cpf deve ser preenchido")
    @CPF(message = "cpf precisa ser valido")
    private String cpf;

}
