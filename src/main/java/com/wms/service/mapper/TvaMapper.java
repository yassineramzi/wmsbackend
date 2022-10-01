package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Tva;
import com.wms.service.dto.TvaDTO;

@Mapper(componentModel = "spring", uses = {CompteMapper.class, AssocieMapper.class})
public interface TvaMapper extends EntityMapper<TvaDTO, Tva>{
    @Override
    TvaDTO toDto(Tva tva);

    @Override
    List<TvaDTO> toDto(List<Tva> tva);

    @Override
    Tva toEntity(TvaDTO tvaDto);

    @Override
    List<Tva> toEntity(List<TvaDTO> tvaDto);

    default Tva fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tva Tva = new Tva();
        Tva.setId(id);
        return Tva;
    }
}
