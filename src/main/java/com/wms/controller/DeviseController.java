package com.wms.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.wms.service.DeviseService;
import com.wms.dto.DeviseDTO;

@RestController
@RequestMapping("/api/devise")
@Slf4j
public class DeviseController {

    private final DeviseService deviseService;

    public DeviseController(final DeviseService deviseService) {
        this.deviseService = deviseService;
    }

    @PostMapping("/create")
    public DeviseDTO create(@RequestBody final DeviseDTO deviseDTO) {
        log.info("Création d'un devise : {}", deviseDTO);
        return this.deviseService.create(deviseDTO);
    }

    @GetMapping("/all")
    public List<DeviseDTO> findAll() {
        log.info("Récupération des devise :");
        return this.deviseService.findAll();
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") final Long id) {
        log.info("Suppression du devise {}", id);
        this.deviseService.delete(id);
    }
}
