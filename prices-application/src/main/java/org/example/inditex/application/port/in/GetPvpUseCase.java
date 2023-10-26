package org.example.inditex.application.port.in;

import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;

public interface GetPvpUseCase {

  Pvp resolve(PvpResolver resolver);

}
