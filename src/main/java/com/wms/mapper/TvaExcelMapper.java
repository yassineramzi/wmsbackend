package com.wms.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Tva;
import com.wms.dto.TvaExcelDTO;

@Mapper(componentModel = "spring")
public interface TvaExcelMapper extends EntityMapper<TvaExcelDTO, Tva>{
    @Override
    TvaExcelDTO toDto(Tva tva);

    @Override
    List<TvaExcelDTO> toDto(List<Tva> tva);

    @Override
    Tva toEntity(TvaExcelDTO tvaExcelDTO);

    @Override
    List<Tva> toEntity(List<TvaExcelDTO> tvaExcelDTO);

    default Tva fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tva Tva = new Tva();
        Tva.setId(id);
        return Tva;
    }
}
