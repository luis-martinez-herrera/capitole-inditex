package org.example.inditex.adapter.out.persistance;

import java.util.Comparator;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.example.inditex.adapter.out.persistance.mapper.PvpMapper;
import org.example.inditex.adapter.out.persistance.entity.PvpEntity;
import org.example.inditex.adapter.out.persistance.repository.PvpRepository;
import org.example.inditex.adapter.out.persistance.repository.spec.PvpSpecification;
import org.example.inditex.application.domain.model.Pvp;
import org.example.inditex.application.domain.model.PvpResolver;
import org.example.inditex.application.port.out.GetPvpPort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PvpPersistenceAdapter implements GetPvpPort {

    private final PvpRepository pvpRepository;

    @Override
    public Pvp resolve(final PvpResolver resolver) {
        final Specification<PvpEntity> specification = this.buildPvpSpecification(resolver);

        return this.pvpRepository.findAll(specification)
                .stream()
                .max(Comparator.comparing(PvpEntity::getPriority))
                .map(PvpMapper.INSTANCE::toPvp)
                .orElseThrow(NoSuchElementException::new);
    }

    private Specification<PvpEntity> buildPvpSpecification(final PvpResolver resolver){
        return new PvpSpecification(resolver.date(), resolver.productId(), resolver.brandId());
    }

}
