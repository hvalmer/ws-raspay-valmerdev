package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Cliente",
        description = "Operações relacionadas ao cadastro e atualização de clientes."
)

public interface CustomerController {

    @Operation(summary = "Cadastrar um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente criado ou atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = CustomerModel.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro na requisição enviada pelo cliente"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no serviço"
            )
    })

    @PostMapping
    ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerDto customerDto);
}
