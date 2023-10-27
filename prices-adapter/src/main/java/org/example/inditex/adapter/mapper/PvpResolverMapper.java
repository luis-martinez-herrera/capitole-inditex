package org.example.inditex.adapter.mapper;

import org.example.inditex.adapter.in.web.dto.PvpResolverRequestDto;
import org.example.inditex.adapter.in.web.dto.PvpResponseDto;
import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PvpResolverMapper {

  PvpResolverMapper INSTANCE = Mappers.getMapper(PvpResolverMapper.class);

  PvpResolver toPvpResolver(PvpResolverRequestDto requestDto);

  PvpResponseDto toPvpResponse(Pvp pvp);
}
