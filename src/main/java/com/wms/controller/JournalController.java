package com.wms.controller;

import com.wms.dto.JournalDTO;
import com.wms.exceptions.ResourceNotFoundException;
import com.wms.service.JournalService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/journal")
@RestController
@Slf4j
@Api(tags = "journal")
public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping("/create")
    public JournalDTO save(@RequestBody @Validated JournalDTO journalDto) {
        return journalService.save(journalDto);
    }

    @GetMapping("/all")
    public List<JournalDTO> findAll() {
        log.info("Récupération des journaux :");
        return journalService.findAll();
    }

    @GetMapping("/{id}")
    public JournalDTO findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return journalService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional.ofNullable(journalService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException();
        });
        journalService.deleteById(id);
    }

    @GetMapping("/page-query")
    public Page<JournalDTO> pageQuery(JournalDTO journalDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<JournalDTO> journalPage = journalService.findByCondition(journalDto, pageable);
        return journalPage;
    }

    @PutMapping("/{id}")
    public JournalDTO update(@RequestBody @Validated JournalDTO journalDto, @PathVariable("id") Long id) throws ResourceNotFoundException {
        return journalService.update(journalDto, id);
    }
}
