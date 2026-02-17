package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;

public class CustomerMapper {

    private CustomerMapper(){}

    // CREATE: DTO -> Model (sem id)
    public static CustomerModel fromDtoToModel(CustomerDto dto) {
        return CustomerModel.builder()
                // .id(dto.getId()) // REMOVER: id vem do Mongo / backend
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .build();
    }

    // UPDATE: mantém id/cpf (e o que você quiser travar), troca o resto
    public static CustomerModel fromModelToModel(CustomerModel current, CustomerDto update) {
        return CustomerModel.builder()
                .id(current.getId())
                .cpf(current.getCpf())
                .email(current.getEmail()) // se quiser permitir atualizar email, use update.getEmail()
                .firstName(update.getFirstName())
                .lastName(update.getLastName())
                .build();
    }

    // RESPONSE: Model -> DTO
    public static CustomerDto fromModelToDto(CustomerModel model) {
        return CustomerDto.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .cpf(model.getCpf())
                .build();
    }
}
