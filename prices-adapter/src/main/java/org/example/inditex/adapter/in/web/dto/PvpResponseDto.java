package org.example.inditex.adapter.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PvpResponseDto {

  private int productId;

  private int brandId;

  private int priceId;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private BigDecimal price;

  private String currency;
}
