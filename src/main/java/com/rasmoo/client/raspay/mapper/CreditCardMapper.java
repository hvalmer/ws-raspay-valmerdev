package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.CreditCardDto;
import com.rasmoo.client.raspay.model.CreditCardModel;

public class CreditCardMapper {

    private CreditCardMapper(){}

    public static CreditCardModel fromDtoToModel(CreditCardDto dto, String customerId) {
        return CreditCardModel.builder()
                .number(dto.getNumber())
                .cvv(dto.getCvv() == null ? null : Long.valueOf(dto.getCvv()))
                .month(dto.getMonth() == null ? null : dto.getMonth().longValue())
                .year(dto.getYear() == null ? null : dto.getYear().longValue())
                .documentNumber(dto.getDocumentNumber())
                .installments(dto.getInstallments() == null ? null : dto.getInstallments().longValue())
                .customerId(customerId)
                .build();
    }

    public static CreditCardDto fromModelToDto(CreditCardModel model) {
        return CreditCardDto.builder()
                .number(model.getNumber())
                .cvv(model.getCvv() == null ? null : String.format("%03d", model.getCvv()))
                .month(model.getMonth() == null ? null : model.getMonth().intValue())
                .year(model.getYear() == null ? null : model.getYear().intValue())
                .documentNumber(model.getDocumentNumber())
                .installments(model.getInstallments() == null ? null : model.getInstallments().intValue())
                .build();
    }
}
