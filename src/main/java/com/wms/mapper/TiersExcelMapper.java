package com.wms.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Tiers;
import com.wms.dto.TiersExcelDTO;

@Mapper(componentModel = "spring")
public interface TiersExcelMapper extends EntityMapper<TiersExcelDTO, Tiers>{
    @Override
    TiersExcelDTO toDto(Tiers tiers);

    @Override
    List<TiersExcelDTO> toDto(List<Tiers> tiers);

    @Override
    Tiers toEntity(TiersExcelDTO TiersExcelDTO);

    @Override
    List<Tiers> toEntity(List<TiersExcelDTO> TiersExcelDTO);

    default Tiers fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tiers Tiers = new Tiers();
        Tiers.setId(id);
        return Tiers;
    }
}
