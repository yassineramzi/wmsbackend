package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Compte;
import com.wms.service.dto.CompteDTO;

@Mapper(componentModel = "spring", uses = {})
public interface CompteMapper extends EntityMapper<CompteDTO, Compte>{
    @Override
    CompteDTO toDto(Compte compte);

    @Override
    List<CompteDTO> toDto(List<Compte> comptes);

    @Override
    Compte toEntity(CompteDTO compteDto);

    @Override
    List<Compte> toEntity(List<CompteDTO> comptesDto);

    default Compte fromId(Long id) {
        if (id == null) {
            return null;
        }
        Compte Compte = new Compte();
        Compte.setId(id);
        return Compte;
    }
}
