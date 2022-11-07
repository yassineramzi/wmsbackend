package com.wms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wms.service.ImportCsvService;

@RestController
@RequestMapping("/api/import")
@Slf4j
public class ImportCsvController {

    private final ImportCsvService importCsvService;

    public ImportCsvController(final ImportCsvService importCsvService){
        this.importCsvService = importCsvService;
    }

    @PostMapping("/{type}")
    public  ResponseEntity<Resource> uploadCSVFile(
        @RequestParam("file") MultipartFile file,
        @PathVariable("type") final String type) 
    {
        log.info("Upload du CSV du type : {}", type);
        this.importCsvService.importCsvByType(file, type);
        return null;
    }
    
}
