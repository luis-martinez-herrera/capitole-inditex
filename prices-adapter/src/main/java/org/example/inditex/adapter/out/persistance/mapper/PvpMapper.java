package org.example.inditex.adapter.out.persistance.mapper;

import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.example.inditex.application.domain.model.Pvp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PvpMapper {

  PvpMapper INSTANCE = Mappers.getMapper(PvpMapper.class);

  Pvp toPvp(PvpEntity priceEntity);

}
