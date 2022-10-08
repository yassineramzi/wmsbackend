package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Tiers;
import com.wms.service.dto.TiersCsvDTO;

@Mapper(componentModel = "spring")
public interface TiersCsvMapper extends EntityMapper<TiersCsvDTO, Tiers>{
    @Override
    TiersCsvDTO toDto(Tiers tiers);

    @Override
    List<TiersCsvDTO> toDto(List<Tiers> tiers);

    @Override
    Tiers toEntity(TiersCsvDTO tiersCsvDto);

    @Override
    List<Tiers> toEntity(List<TiersCsvDTO> tiersCsvDto);

    default Tiers fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tiers Tiers = new Tiers();
        Tiers.setId(id);
        return Tiers;
    }
}
