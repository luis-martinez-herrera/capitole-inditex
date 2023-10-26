package org.example.inditex.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;
import org.example.inditex.application.port.in.GetPvpUseCase;
import org.example.inditex.application.port.out.GetPvpPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPvpService implements GetPvpUseCase {

  private final GetPvpPort getPvpPort;

  @Override
  public Pvp resolve(final PvpResolver resolver) {
    return getPvpPort.resolve(resolver);
  }
}
