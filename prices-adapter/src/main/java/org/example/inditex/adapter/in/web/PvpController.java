package org.example.inditex.adapter.in.web;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.inditex.adapter.in.web.dto.PvpResolverRequestDto;
import org.example.inditex.adapter.in.web.dto.PvpResponseDto;
import org.example.inditex.adapter.mapper.PvpResolverMapper;
import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.port.in.GetPvpUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PvpController {

  private final GetPvpUseCase getPvpUseCase;

  @GetMapping(
      value = "/pvp",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public PvpResponseDto getPvp(@Valid final PvpResolverRequestDto dto) {
    final Pvp pvp = getPvpUseCase.resolve(PvpResolverMapper.INSTANCE.toPvpResolver(dto));
    return PvpResolverMapper.INSTANCE.toPvpResponse(pvp);
  }
}
