package com.wms.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wms.service.ImportCsvService;
import com.wms.service.PersistCsvService;

@Service
public class ImportCsvServiceImpl implements ImportCsvService {
    private final Logger log = LoggerFactory.getLogger(ImportCsvServiceImpl.class);

    private PersistCsvService persistCsvService;

    private final ApplicationContext appContext;

    @Autowired
    public ImportCsvServiceImpl(final ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Override
    public boolean importCsvByType(MultipartFile file, String type) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            this.persistCsvService = (PersistCsvService) this.appContext.getBean(type);
            this.persistCsvService.saveCsv(reader);
        } catch (Exception ex) {
            log.error("Une erreur : {} , est survenue lors de l'import d'un CSV du type : {}", ex.getMessage(), type);
        }
        return false;
    }
    
}
