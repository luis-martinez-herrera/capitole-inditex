package com.example.inditex.prices.service;

import com.example.inditex.prices.controller.dto.PvpRequestDto;
import com.example.inditex.prices.controller.dto.PvpResponseDto;

public interface PriceService {

    PvpResponseDto searchPvp (PvpRequestDto requestDto);
}
