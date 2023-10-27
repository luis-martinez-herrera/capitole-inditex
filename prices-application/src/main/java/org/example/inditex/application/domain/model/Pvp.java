package org.example.inditex.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Value
public class Pvp {

  int priceId;

  int productId;

  int brandId;

  LocalDateTime startDate;

  LocalDateTime endDate;

  BigDecimal price;

  String currency;

  int priority;
}
