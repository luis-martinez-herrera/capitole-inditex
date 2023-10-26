package org.example.inditex.adapter.out.persistance;

import static org.junit.jupiter.api.Assertions.*;

import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.example.inditex.adapter.out.persistance.repository.PvpRepository;
import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PvpPersistenceAdapterTest {

    @Mock
    PvpRepository priceRepository;

    @InjectMocks
    PvpPersistenceAdapter priceService;

//    @Test
//    void testEmpty() {
//        PvpResolver requestDto = new PvpResolver();
//        List<PvpEntity> entities = new ArrayList<>();
//        Mockito.when(priceRepository.findAll(ArgumentMatchers.<Specification<PvpEntity>>any())).thenReturn(entities);
//
//        assertThrows(NoSuchElementException.class, () -> this.priceService.resolve(requestDto));
//    }

    @Test
    void testOneResult() {
        List<PvpEntity> entities = new ArrayList<>();
        PvpEntity priceEntity = new PvpEntity();
        priceEntity.setPriority(0);
        priceEntity.setProductId(35455);
        priceEntity.setBrandId(1);
        priceEntity.setPrice(new BigDecimal("35.50"));
        priceEntity.setPriceId(4);
        priceEntity.setCurrency("EUR");

        LocalDateTime expectedStartDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime expectedEndDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        priceEntity.setStartDate(expectedStartDate);
        priceEntity.setEndDate(expectedEndDate);

        entities.add(priceEntity);

        Mockito.when(priceRepository.findAll(ArgumentMatchers.<Specification<PvpEntity>>any())).thenReturn(entities);

        PvpResolver requestDto = new PvpResolver(LocalDateTime.now(), 1,1);
        Pvp pvpResponseDto = this.priceService.resolve(requestDto);

        assertNotNull(pvpResponseDto);
        assertEquals(35455, pvpResponseDto.getProductId());
        assertEquals(1, pvpResponseDto.getBrandId());
        assertEquals(new BigDecimal("35.50"), pvpResponseDto.getPrice());
        assertEquals(4, pvpResponseDto.getPriceId());
        assertEquals("EUR", pvpResponseDto.getCurrency());
        assertEquals(expectedStartDate, pvpResponseDto.getStartDate());
        assertEquals(expectedEndDate, pvpResponseDto.getEndDate());
    }
//
//    @Test
//    void testMultipleResult() {
//        PvpRequestDto requestDto = new PvpRequestDto();
//
//        List<PriceEntity> entities = new ArrayList<>();
//        PriceEntity priceEntity1 = new PriceEntity();
//        priceEntity1.setPriority(0);
//        priceEntity1.setProductId(35455);
//        priceEntity1.setBrandId(1);
//        priceEntity1.setPrice(new BigDecimal("35.50"));
//        priceEntity1.setPriceId(1);
//        priceEntity1.setCurrency("EUR");
//
//        LocalDateTime expectedStartDate1 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
//        LocalDateTime expectedEndDate1 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
//        priceEntity1.setStartDate(expectedStartDate1);
//        priceEntity1.setEndDate(expectedEndDate1);
//
//        entities.add(priceEntity1);
//
//        PriceEntity priceEntity2 = new PriceEntity();
//        priceEntity2.setPriority(1);
//        priceEntity2.setProductId(35455);
//        priceEntity2.setBrandId(1);
//        priceEntity2.setPrice(new BigDecimal("25.45"));
//        priceEntity2.setPriceId(2);
//        priceEntity2.setCurrency("EUR");
//
//        LocalDateTime expectedStartDate2 = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
//        LocalDateTime expectedEndDate2 = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
//        priceEntity2.setStartDate(expectedStartDate2);
//        priceEntity2.setEndDate(expectedEndDate2);
//
//        entities.add(priceEntity2);
//
//        Mockito.when(priceRepository.findAll(ArgumentMatchers.<Specification<PriceEntity>>any())).thenReturn(entities);
//        PvpResponseDto pvpResponseDto = this.priceService.searchPvp(requestDto);
//
//        assertNotNull(pvpResponseDto);
//        assertEquals(35455, pvpResponseDto.getProductId());
//        assertEquals(1, pvpResponseDto.getBrandId());
//        assertEquals(new BigDecimal("25.45"), pvpResponseDto.getPrice());
//        assertEquals(2, pvpResponseDto.getPriceId());
//        assertEquals("EUR", pvpResponseDto.getCurrency());
//        assertEquals(expectedStartDate2, pvpResponseDto.getStartDate());
//        assertEquals(expectedEndDate2, pvpResponseDto.getEndDate());
//    }
}
