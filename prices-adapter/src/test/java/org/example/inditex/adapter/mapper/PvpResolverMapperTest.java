package org.example.inditex.adapter.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.example.inditex.adapter.in.web.dto.PvpResolverRequestDto;
import org.example.inditex.adapter.in.web.dto.PvpResponseDto;
import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;
import org.junit.jupiter.api.Test;

class PvpResolverMapperTest {

    @Test
    void toPvpResolver() {
        PvpResolverRequestDto dto = new PvpResolverRequestDto();
        dto.setBrandId(1);
        dto.setProductId(2);

        LocalDateTime time = LocalDateTime.now();
        dto.setDate(time);

        PvpResolver resolver = PvpResolverMapper.INSTANCE.toPvpResolver(dto);
        assertEquals(1, resolver.brandId());
        assertEquals(2, resolver.productId());
        assertEquals(time, resolver.date());
      }

    @Test
    void toPvpResponse() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(1);

        Pvp  pvp = new Pvp(1,2,3, start, end, BigDecimal.ONE, "EUR", 4);

        PvpResponseDto response = PvpResolverMapper.INSTANCE.toPvpResponse(pvp);
        assertEquals(1, response.getPriceId());
        assertEquals(2, response.getProductId());
        assertEquals(3, response.getBrandId());
        assertEquals(start, response.getStartDate());
        assertEquals(end, response.getEndDate());
        assertEquals(BigDecimal.ONE, response.getPrice());
        assertEquals("EUR", response.getCurrency());
      }
}