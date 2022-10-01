package com.wms.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wms.service.PlanComptableService;
import com.wms.service.dto.PlanComptableDTO;

@RestController
@RequestMapping("/api/plan-comptable")
public class PlanComptableApi {
    private final Logger log = LoggerFactory.getLogger(PlanComptableApi.class);

    private final PlanComptableService planComptableService;

    @Autowired
    public PlanComptableApi(final PlanComptableService planComptableService) {
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
