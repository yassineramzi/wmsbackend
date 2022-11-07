package com.wms.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Tiers;
import com.wms.dto.TiersDTO;

@Mapper(componentModel = "spring")
public interface TiersMapper extends EntityMapper<TiersDTO, Tiers>{
    @Override
    TiersDTO toDto(Tiers tiers);

    @Override
    List<TiersDTO> toDto(List<Tiers> tiers);

    @Override
    Tiers toEntity(TiersDTO tiersDto);

    @Override
    List<Tiers> toEntity(List<TiersDTO> tiersDto);

    default Tiers fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tiers Tiers = new Tiers();
        Tiers.setId(id);
        return Tiers;
    }
}
