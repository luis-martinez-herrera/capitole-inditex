package org.example.inditex.adapter.out.persistance.repository;

import org.example.inditex.adapter.out.persistance.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer>, JpaSpecificationExecutor<PriceEntity> {

}
