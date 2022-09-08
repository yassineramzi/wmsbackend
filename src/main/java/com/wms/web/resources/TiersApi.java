package com.wms.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wms.service.TiersService;
import com.wms.service.dto.TiersDTO;

@RestController
@RequestMapping("/api/tiers")
public class TiersApi {
    private final Logger log = LoggerFactory.getLogger(TiersApi.class);

    private final TiersService tiersService;

    @Autowired
    public TiersApi(final TiersService tiersService) {
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
