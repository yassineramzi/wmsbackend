package com.wms.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Dossier;
import com.wms.dto.DossierDTO;

@Mapper(componentModel = "spring", uses = {CompteMapper.class, AssocieMapper.class})
public interface DossierMapper extends EntityMapper<DossierDTO, Dossier>{
    @Override
    DossierDTO toDto(Dossier dossier);

    @Override
    List<DossierDTO> toDto(List<Dossier> dossiers);

    @Override
    Dossier toEntity(DossierDTO dossierDto);

    @Override
    List<Dossier> toEntity(List<DossierDTO> dossiersDto);

    default Dossier fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dossier Dossier = new Dossier();
        Dossier.setId(id);
        return Dossier;
    }
}
