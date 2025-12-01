package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Product", description = "Endpoints relacionados a produtos.")
public interface ProductController {

    @Operation(
            summary = "Criar novo produto",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Produto criado com sucesso",
                            content = @Content(schema = @Schema(implementation = ProductModel.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro ao criar o produto"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no serviço"
                    )
            }
    )
    ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto);

    @Operation(
            summary = "Lista todos os produtos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sucesso na consulta",
                            content = @Content(schema = @Schema(implementation = ProductModel.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no serviço"
                    )
            }
    )

    ResponseEntity<List<ProductModel>> readAll();
}
