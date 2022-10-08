package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Devise;
import com.wms.service.dto.DeviseDTO;

@Mapper(componentModel = "spring")
public interface DeviseMapper extends EntityMapper<DeviseDTO, Devise>{
    @Override
    DeviseDTO toDto(Devise devise);

    @Override
    List<DeviseDTO> toDto(List<Devise> devise);

    @Override
    Devise toEntity(DeviseDTO deviseDto);

    @Override
    List<Devise> toEntity(List<DeviseDTO> deviseDto);

    default Devise fromId(Long id) {
        if (id == null) {
            return null;
        }
        Devise Devise = new Devise();
        Devise.setId(id);
        return Devise;
    }
}
