package org.example.inditex.adapter.out.persistance.repository.spec;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class PvpSpecification implements Specification<PvpEntity> {

  private final LocalDateTime date;

  private final int productId;

  private final int brandId;

  @Override
  public Predicate toPredicate(
      final Root<PvpEntity> root,
      final CriteriaQuery<?> criteriaQuery,
      final CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();

    predicates.add(criteriaBuilder.equal(root.get("productId"), this.productId));
    predicates.add(criteriaBuilder.equal(root.get("brandId"), this.brandId));
    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), this.date));
    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), this.date));

    return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
  }
}
