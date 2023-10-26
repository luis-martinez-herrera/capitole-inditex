package org.example.inditex.adapter.out.persistance.repository;

import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PvpRepository
    extends JpaRepository<PvpEntity, Integer>, JpaSpecificationExecutor<PvpEntity> {}
