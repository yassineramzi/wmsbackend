package com.wms.web.resources;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.service.ExportService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/export")
@AllArgsConstructor
public class ExportApi {

    private final ExportService exportService;

    @GetMapping("/{type}")
    public void exportIntoExcelFile(HttpServletResponse response, @PathVariable("type") final String type) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+type+"-"+ currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        exportService.generateExcelFile(response, type);
    }
    
}
