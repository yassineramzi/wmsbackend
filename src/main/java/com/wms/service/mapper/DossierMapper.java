package com.wms.service.mapper;

import org.mapstruct.Mapper;

import com.wms.domain.Dossier;
import com.wms.service.dto.DossierDTO;

@Mapper(componentModel = "spring", uses = {})
public interface DossierMapper extends EntityMapper<DossierDTO, Dossier>{
    @Override
    DossierDTO toDto(Dossier Dossier);

    @Override
    Dossier toEntity(DossierDTO DossierDto);

    default Dossier fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dossier Dossier = new Dossier();
        Dossier.setId(id);
        return Dossier;
    }
}
