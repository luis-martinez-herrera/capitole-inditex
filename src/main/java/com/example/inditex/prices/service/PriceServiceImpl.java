package com.example.inditex.prices.service;

import com.example.inditex.prices.controller.dto.PvpRequestDto;
import com.example.inditex.prices.controller.dto.PvpResponseDto;
import com.example.inditex.prices.dao.entity.PriceEntity;
import com.example.inditex.prices.dao.repository.PriceRepository;
import com.example.inditex.prices.dao.repository.spec.PvpSpecification;
import com.example.inditex.prices.mapper.PriceMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PvpResponseDto searchPvp (PvpRequestDto requestDto){
        List<PriceEntity> entities = this.priceRepository.findAll(this.buildPvpSpecification(requestDto));

        return entities
                .stream()
                .max(Comparator.comparing(PriceEntity::getPriority))
                .map(PriceMapper.INSTANCE::toDto)
                .orElseThrow(NoSuchElementException::new);
    }

    private Specification<PriceEntity> buildPvpSpecification (PvpRequestDto requestDto){
        return new PvpSpecification(requestDto.getDate(), requestDto.getProductId(), requestDto.getBrandId());
    }
}
