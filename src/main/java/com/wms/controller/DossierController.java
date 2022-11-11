package com.wms.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.wms.service.DossierService;
import com.wms.dto.DossierDTO;

@RestController
@RequestMapping("/api/dossier")
@Slf4j
public class DossierController {

    private final DossierService dossierService;

    public DossierController(final DossierService dossierService) {
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
}
