package com.example.inditex.prices.service;

import com.example.inditex.prices.controller.dto.PvpRequestDto;
import com.example.inditex.prices.controller.dto.PvpResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Override
    public PvpResponseDto searchPvp (PvpRequestDto requestDto){
        return new PvpResponseDto();
    }
}
