package com.wms.web.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.wms.service.ExportService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/export")
@AllArgsConstructor
public class ExportApi {

    private final ExportService exportService;

    @GetMapping("/{type}")
    public void exportIntoExcelFile(HttpServletResponse response, @PathVariable("type") final String type) throws IOException, DocumentException {
        exportService.generateFile(response, type);
    }
    
}
