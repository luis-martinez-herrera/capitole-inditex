package org.example.inditex.application.port.out;

import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;

public interface GetPvpPort {

    Pvp resolve(PvpResolver resolver);

}
