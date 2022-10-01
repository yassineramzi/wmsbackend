package com.wms.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wms.service.TvaService;
import com.wms.service.dto.TvaDTO;

@RestController
@RequestMapping("/api/tva")
public class TvaApi {
    private final Logger log = LoggerFactory.getLogger(TvaApi.class);

    private final TvaService tvaService;

    @Autowired
    public TvaApi(final TvaService tvaService) {
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
