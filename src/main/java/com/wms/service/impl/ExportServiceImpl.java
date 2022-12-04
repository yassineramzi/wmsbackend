package com.wms.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.wms.service.ExcelExportService;
import com.wms.service.ExportService;
import com.wms.service.PdfExportService;

@Service
public class ExportServiceImpl implements ExportService{

    private final Logger log = LoggerFactory.getLogger(ExportServiceImpl.class);

    private final ApplicationContext appContext;

    @Autowired
    public ExportServiceImpl(final ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Override
    public void generateFile(HttpServletResponse response, String type) throws IOException, DocumentException {
        log.info("Export de type : {}", type);
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        if(type.contains("excel")){
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename="+type+"-"+ currentDateTime + ".xlsx";
            response.setHeader(headerKey, headerValue);
            ExcelExportService excelExportService = (ExcelExportService) this.appContext.getBean(type);
            excelExportService.generateExcelFile(response);
        } else if(type.contains("pdf")) {
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename="+type+"-"+ currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);
            PdfExportService pdfExportService = (PdfExportService) this.appContext.getBean(type);
            pdfExportService.generatePdfFile(response);
        }
    }
    
}
