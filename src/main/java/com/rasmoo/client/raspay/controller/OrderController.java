package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.OrderModel;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Pedido",
        description = "Operações para criação de pedidos vinculados a um cliente existente."

)
public interface OrderController {

    @Operation(summary = "Cadastrar um novo pedido")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Pedido criado com sucesso",
                    content = @Content(schema = @Schema(implementation = OrderModel.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro na requisição do pedido"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no serviço"
            )
    })

    @PostMapping(
            consumes = "application/jason",
            produces = "application/jason"
    )

    ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto);
}
