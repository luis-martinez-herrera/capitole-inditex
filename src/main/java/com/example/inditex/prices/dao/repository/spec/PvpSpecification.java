package com.example.inditex.prices.dao.repository.spec;

import com.example.inditex.prices.dao.entity.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PvpSpecification implements Specification<PriceEntity> {

    private final LocalDateTime date;
    private final int productId;
    private final int brandId;

    public PvpSpecification(LocalDateTime date, int productId, Integer brandId) {
        this.date = date;
        this.productId = productId;
        this.brandId = brandId;
    }

    @Override
    public Predicate toPredicate(Root<PriceEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.get("productId"), this.productId));
        predicates.add(criteriaBuilder.equal(root.get("brandId"), this.brandId));
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), this.date));
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), this.date));

        return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }

}
