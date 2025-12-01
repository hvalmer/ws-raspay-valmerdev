package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Pagamento",
        description = "Operações relacionadas ao processo de pagamento."
)


public interface PaymentController {

    @Operation(summary = "Processar pagamento")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pagamento realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = Boolean.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro ao processar pagamento"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Pagamento não autorizado"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no serviço"
            )
    })
    @PostMapping
    ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto);
}
