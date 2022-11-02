package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Devise;
import com.wms.service.dto.DeviseExcelDTO;

@Mapper(componentModel = "spring")
public interface DeviseExcelMapper extends EntityMapper<DeviseExcelDTO, Devise>{
    @Override
    DeviseExcelDTO toDto(Devise devise);

    @Override
    List<DeviseExcelDTO> toDto(List<Devise> devise);

    default Devise fromId(Long id) {
        if (id == null) {
            return null;
        }
        Devise devise = new Devise();
        devise.setId(id);
        return devise;
    }
}
