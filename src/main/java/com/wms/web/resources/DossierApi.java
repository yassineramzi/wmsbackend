package com.wms.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wms.service.DossierService;
import com.wms.service.dto.DossierDTO;

@RestController
@RequestMapping("/api/dossier")
public class DossierApi {
    private final Logger log = LoggerFactory.getLogger(DossierApi.class);

    private final DossierService dossierService;

    @Autowired
    public DossierApi(final DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @PostMapping("/create")
    public DossierDTO create(@RequestBody final DossierDTO dossierDTO) {
        log.info("Création d'un dossier : {}", dossierDTO);
        return this.dossierService.create(dossierDTO);
    }

    @GetMapping("/all")
    public List<DossierDTO> findAll() {
        log.info("Récupération des dossier :");
        return this.dossierService.findAll();
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") final Long id) {
        log.info("Suppression du dossier {}", id);
        this.dossierService.delete(id);
    }
    
    
    @PutMapping("/{id}/update")  
    public DossierDTO update(@RequestBody  final DossierDTO dossierDTO  ,@PathVariable("id") final long id )   
    {  
    	 log.info("Modification du dossier {}", dossierDTO);
    	  return this.dossierService.update( dossierDTO ,id); 
    }
    
    
    
    @GetMapping("/findbyid/{id}")
    public DossierDTO findbyId(final long id) {
        log.info("Récupération des dossier :");
        return this.dossierService.findbyId(id); 
    
    
    }
    
    
}
