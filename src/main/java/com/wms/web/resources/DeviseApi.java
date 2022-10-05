package com.wms.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wms.service.DeviseService;
import com.wms.service.dto.DeviseDTO;

@RestController
@RequestMapping("/api/devise")
public class DeviseApi {
    private final Logger log = LoggerFactory.getLogger(DeviseApi.class);

    private final DeviseService deviseService;

    @Autowired
    public DeviseApi(final DeviseService deviseService) {
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
