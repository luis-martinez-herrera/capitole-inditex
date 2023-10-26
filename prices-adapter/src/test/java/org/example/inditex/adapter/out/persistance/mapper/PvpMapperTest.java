package org.example.inditex.adapter.out.persistance.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.example.inditex.application.domain.model.Pvp;
import org.junit.jupiter.api.Test;

class PvpMapperTest {

  @Test
  void toPvp() {
    PvpEntity entity = new PvpEntity();
    entity.setBrandId(1);

    Pvp pvp = PvpMapper.INSTANCE.toPvp(entity);
    assertEquals(1, pvp.getBrandId());
  }
}
