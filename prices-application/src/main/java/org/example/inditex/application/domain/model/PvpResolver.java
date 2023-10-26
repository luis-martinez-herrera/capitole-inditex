package org.example.inditex.application.domain.model;

import java.time.LocalDateTime;

public record PvpResolver(LocalDateTime date, int productId, int brandId) {

}
