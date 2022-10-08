package com.wms.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportCsvService {
    boolean importCsvByType(MultipartFile file, final String type);
}
