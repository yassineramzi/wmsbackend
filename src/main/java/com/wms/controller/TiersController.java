package com.wms.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.wms.service.TiersService;
import com.wms.dto.TiersDTO;

@RestController
@RequestMapping("/api/tiers")
@Slf4j
public class TiersController {

    private final TiersService tiersService;

    public TiersController(final TiersService tiersService) {
        this.tiersService = tiersService;
    }

    @PostMapping("/create")
    public TiersDTO create(@RequestBody final TiersDTO tiersDTO) {
        log.info("Création d'un tiers : {}", tiersDTO);
        return this.tiersService.create(tiersDTO);
    }

    @GetMapping("/all")
    public List<TiersDTO> findAll() {
        log.info("Récupération des tiers :");
        return this.tiersService.findAll();
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") final Long id) {
        log.info("Suppression du tiers {}", id);
        this.tiersService.delete(id);
    }
}
