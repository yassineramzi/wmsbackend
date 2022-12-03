package com.wms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.wms.domain.Dossier;
import com.wms.repository.DossierRepository;
import com.wms.service.DossierService;
import com.wms.service.dto.DossierDTO;
import com.wms.service.mapper.DossierMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DossierServiceImpl implements DossierService {

    private DossierRepository dossierRepository;

    private DossierMapper dossierMapper;

    @Override
    public DossierDTO create(final DossierDTO dossierDto) {
        Dossier dossier = this.dossierMapper.toEntity(dossierDto);
        return this.dossierMapper.toDto(this.dossierRepository.save(dossier));
    }

    @Override
    public List<DossierDTO> findAll() {
        return this.dossierMapper.toDto(this.dossierRepository.findAll());
    }

    @Override
    public void delete(final Long id){
        this.dossierRepository.deleteById(id);
    }

	@Override
	public DossierDTO update(DossierDTO dossierDTO, long id) {
		
		 Dossier dossierEntity  = dossierRepository.findById(id).get();
		 
			
		  if(dossierEntity == null) throw new NoSuchElementException("le dossier avec id:" +id+" nexiste pas  ");
		  
		  Dossier dossierEntityMapped =this.dossierMapper.toEntity(dossierDTO);
		  
		  dossierEntityMapped.setId(dossierEntity.getId());
		  
		  Dossier dossierUpdated =this.dossierRepository.save( dossierEntityMapped);
		  
		  
		  
		  
        return this.dossierMapper.toDto(dossierUpdated);
		
		
	}


	
    
}

