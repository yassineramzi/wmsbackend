package com.wms.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.wms.service.ExcelExportService;
import com.wms.service.ExportService;

@Service
public class ExportServiceImpl implements ExportService{

    private ExcelExportService excelExportService;

    private final Logger log = LoggerFactory.getLogger(ExportServiceImpl.class);

    private final ApplicationContext appContext;

    @Autowired
    public ExportServiceImpl(final ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Override
    public void generateExcelFile(HttpServletResponse response, String type) throws IOException {
        log.info("Export Excel de type : {}", type);
        this.excelExportService = (ExcelExportService) this.appContext.getBean(type);
        this.excelExportService.generateExcelFile(response);
    }
    
}
