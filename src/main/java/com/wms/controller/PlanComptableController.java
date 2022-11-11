package com.wms.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.wms.service.PlanComptableService;
import com.wms.dto.PlanComptableDTO;

@RestController
@RequestMapping("/api/plan-comptable")
@Slf4j
public class PlanComptableController {

    private final PlanComptableService planComptableService;

    public PlanComptableController(final PlanComptableService planComptableService) {
        this.planComptableService = planComptableService;
    }

    @PostMapping("/create")
    public PlanComptableDTO create(@RequestBody final PlanComptableDTO planComptableDTO) {
        log.info("Création d'un planComptable : {}", planComptableDTO);
        return this.planComptableService.create(planComptableDTO);
    }

    @GetMapping("/all")
    public List<PlanComptableDTO> findAll() {
        log.info("Récupération des planComptable :");
        return this.planComptableService.findAll();
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") final Long id) {
        log.info("Suppression du planComptable {}", id);
        this.planComptableService.delete(id);
    }
}
