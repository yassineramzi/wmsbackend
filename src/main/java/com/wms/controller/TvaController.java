package com.wms.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.wms.service.TvaService;
import com.wms.dto.TvaDTO;

@RestController
@RequestMapping("/api/tva")
@Slf4j
public class TvaController {

    private final TvaService tvaService;

    public TvaController(final TvaService tvaService) {
        this.tvaService = tvaService;
    }

    @PostMapping("/create")
    public TvaDTO create(@RequestBody final TvaDTO tvaDTO) {
        log.info("Création d'un tva : {}", tvaDTO);
        return this.tvaService.create(tvaDTO);
    }

    @GetMapping("/all")
    public List<TvaDTO> findAll() {
        log.info("Récupération des tva :");
        return this.tvaService.findAll();
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") final Long id) {
        log.info("Suppression du tva {}", id);
        this.tvaService.delete(id);
    }
}
