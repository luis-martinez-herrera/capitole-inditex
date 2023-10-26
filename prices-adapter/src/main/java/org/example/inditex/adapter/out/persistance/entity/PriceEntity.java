package org.example.inditex.adapter.out.persistance.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    private int priceId;

    private int productId;

    private int brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal price;

    private String currency;

    private int priority;

}
