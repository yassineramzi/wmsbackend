package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Tva;
import com.wms.service.dto.TvaCsvDTO;

@Mapper(componentModel = "spring")
public interface TvaCsvMapper extends EntityMapper<TvaCsvDTO, Tva>{
    @Override
    TvaCsvDTO toDto(Tva tva);

    @Override
    List<TvaCsvDTO> toDto(List<Tva> tva);

    @Override
    Tva toEntity(TvaCsvDTO tvaCsvDto);

    @Override
    List<Tva> toEntity(List<TvaCsvDTO> tvaCsvDto);

    default Tva fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tva Tva = new Tva();
        Tva.setId(id);
        return Tva;
    }
}
