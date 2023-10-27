package org.example.inditex.adapter.in.web.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class PvpResolverRequestDto {

    @NotNull(message = "Date field is required.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @NotNull(message = "ProductId field is required.")
    private int productId;

    @NotNull(message = "BrandId field is required.")
    private int brandId;

}
