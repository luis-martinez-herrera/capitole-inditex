package com.example.inditex.prices.mapper;

import com.example.inditex.prices.controller.dto.PvpResponseDto;
import com.example.inditex.prices.dao.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PvpResponseDto toDto(PriceEntity priceEntity);

}
