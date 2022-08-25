package com.wms.web.resources;

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

    private DossierService dossierService;

    @Autowired
    public DossierApi(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @PostMapping("/create")
    public DossierDTO create(@RequestBody DossierDTO dossierDTO) {
        log.info("Création d'un dossier :", dossierDTO);
        return this.dossierService.create(dossierDTO);
    }
}
