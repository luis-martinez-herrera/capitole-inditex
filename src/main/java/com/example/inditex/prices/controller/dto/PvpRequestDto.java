package com.example.inditex.prices.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PvpRequestDto {

    @NotNull(message = "Date field is required.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    @NotNull(message = "ProductId field is required.")
    private int productId;
    @NotNull(message = "BrandId field is required.")
    private int brandId;
}
