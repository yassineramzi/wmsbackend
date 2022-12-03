package com.wms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.wms.domain.Associe;
import com.wms.domain.Compte;
import com.wms.domain.Dossier;
import com.wms.repository.DossierRepository;
import com.wms.service.DossierService;
import com.wms.service.dto.AssocieDTO;
import com.wms.service.dto.DossierDTO;
import com.wms.service.mapper.DossierMapper;

import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

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
		
		
		  Dossier dossierEntity  = dossierRepository.findById(id);
			
		  if(dossierEntity == null) throw new NoSuchElementException("le dossier avec id:" +id+" nexiste pas  ");
	
		  dossierEntity.setDenomination(dossierDTO.getDenomination());

           dossierEntity.setIdentifiantFiscal(dossierDTO.getIdentifiantFiscal());
           dossierEntity.setIce(dossierDTO.getIce());
           dossierEntity.setActivite(dossierDTO.getActivite());
           dossierEntity.setAdresse(dossierDTO.getAdresse());
           dossierEntity.setCodePostal(dossierDTO.getCodePostal());

           dossierEntity.setVille(dossierDTO.getVille());
           dossierEntity.setEmail(dossierDTO.getEmail());
           dossierEntity.setFixe(dossierDTO.getFixe());
           dossierEntity.setMobile(dossierDTO.getMobile());


           dossierEntity.setDateCreationSociete(dossierDTO.getDateCreationSociete());
           dossierEntity.setCapital(dossierDTO.getCapital());

           dossierEntity.setValeurPart(dossierDTO.getValeurPart());
           dossierEntity.setFormeJuridique(dossierDTO.getFormeJuridique());

           dossierEntity.setTypeComptabilite(dossierDTO.getTypeComptabilite());
           dossierEntity.setDroitTimbre(dossierDTO.getDroitTimbre());

           dossierEntity.setRegimeTva(dossierDTO.getRegimeTva());
           dossierEntity.setTypeTva(dossierDTO.getTypeTva());

           dossierEntity.setImposition(dossierDTO.getImposition());
           dossierEntity.setRegistreCommerce(dossierDTO.getRegistreCommerce());
           dossierEntity.setNumeroTP(dossierDTO.getNumeroTP());
           

           dossierEntity.setHonoraire(dossierDTO.getHonoraire());
           dossierEntity.setPeriodiciteHonnoraire(dossierDTO.getPeriodiciteHonnoraire());
           dossierEntity.setLogo(dossierDTO.getLogo());
           dossierEntity.setCodeAdhesion(dossierDTO.getCodeAdhesion());



        dossierEntity.setLoginSimpl(dossierDTO.getLoginSimpl());
        dossierEntity.setMotPasseSimpl(dossierDTO.getMotPasseSimpl());
        dossierEntity.setNumeroAffiliationCnss(dossierDTO.getNumeroAffiliationCnss());
        dossierEntity.setCodeUtilisationCnss(dossierDTO.getCodeUtilisationCnss());
        dossierEntity.setMotPasseCnss(dossierDTO.getMotPasseCnss());



       /*List<Associe>  associes = null;
       BeanUtils.copyProperties(associes, dossierDTO.getAssocies());
       dossierEntity.setAssocies(associes);  //BeanUtils.copyProperties(dossierEntity, dossierDTO);
 
       List<Compte>  comptes = null;
       BeanUtils.copyProperties(comptes, dossierDTO.getComptes());
       dossierEntity.setComptes(comptes);*/

		
		  
		  Dossier dossierEntityMapped = dossierRepository.save(dossierEntity);
		  
		  
		  
       return this.dossierMapper.toDto(dossierEntityMapped);
		
		
	}

	@Override
	public DossierDTO findDossierById(long id) {
		  Dossier dossierEntity  = dossierRepository.findById(id);
		  if(dossierEntity == null) throw new NoSuchElementException("le dossier avec id:" +id+" nexiste pas  ");

		  
		  return this.dossierMapper.toDto(dossierEntity);
	}


	
	


	

	
	

	
    
}






   
   
 




 
    
   

