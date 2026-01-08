package com.rasmoo.client.raspay.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Schema(description = "Estrutura padrão de erro da API")
public class ErrorResponseDto {

    @Schema(example = "400")
    private Integer statusCode;

    @Schema(example = "Bad Request")
    private String error;

    @Schema(example = "Erro de validação")
    private String message;

    @Schema(description = "Detalhes do erro")
    private List<String> details;

    @Schema(example = "2026-01-06T14:30:00")
    private LocalDateTime timestamp;
}
