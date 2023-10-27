package org.example.inditex.adapter.out.persistance.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.example.inditex.application.domain.model.Pvp;
import org.junit.jupiter.api.Test;

class PvpMapperTest {

  @Test
  void toPvp() {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = start.plusMinutes(1);

    PvpEntity entity = new PvpEntity();
    entity.setPriceId(1);
    entity.setProductId(2);
    entity.setBrandId(3);
    entity.setStartDate(start);
    entity.setEndDate(end);
    entity.setPrice(BigDecimal.ONE);
    entity.setCurrency("EUR");

    Pvp pvp = PvpMapper.INSTANCE.toPvp(entity);
    assertEquals(1, pvp.getPriceId());
    assertEquals(2, pvp.getProductId());
    assertEquals(3, pvp.getBrandId());
    assertEquals(start, pvp.getStartDate());
    assertEquals(end, pvp.getEndDate());
    assertEquals(BigDecimal.ONE, pvp.getPrice());
    assertEquals("EUR", pvp.getCurrency());
  }
}
