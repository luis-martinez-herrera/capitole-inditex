package com.example.inditex.prices.controller;

import com.example.inditex.prices.controller.dto.PvpRequestDto;
import com.example.inditex.prices.controller.dto.PvpResponseDto;
import com.example.inditex.prices.service.PriceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(value = "/pvp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    PvpResponseDto searchPvp(@Valid PvpRequestDto requestDto) {
        return priceService.searchPvp(requestDto);
    }
}
