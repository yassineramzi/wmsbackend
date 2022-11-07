package com.wms.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public abstract class ExcelImportService<T> {

    protected final List<T> validLigns = new ArrayList<T>();

    protected final List<T> unvalidLigns = new ArrayList<T>();

    protected final static Map<Integer, String> FILE_HEADERS = new HashMap<>();

    protected abstract void createFromRow(final Row row);

    public void importExcelFile(final MultipartFile file) throws Exception {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (StringUtils.equalsIgnoreCase("xlsx", extension) && file != null) {
            this.parseFile((FileInputStream) file.getInputStream());
        } else
            throw new Exception("Le fichier est null ou l'extension du fichier n'est pas conforme");
    }

    protected boolean validateTemplate(final XSSFRow row) {
        boolean isValid = true;
        for (Map.Entry<Integer, String> entry : FILE_HEADERS.entrySet()) {
            Cell cell =row.getCell(entry.getKey());
            if(cell == null || !StringUtils.equalsIgnoreCase(cell.getStringCellValue(), entry.getValue())) {
                return false;
            }
        };
        return isValid;
    }

    protected void parseFile(final FileInputStream file) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook(file);
        try {
            XSSFSheet sheet = wb.getSheetAt(0);
            if (!validateTemplate(sheet.getRow(0))) {
                throw new Exception("Template non conforme");
            }
            int lastRowNumber = sheet.getLastRowNum();
            for(int i=1; i<lastRowNumber; i++) {
                Row row = sheet.getRow(i);
                this.createFromRow(row);
            }
        }catch (Exception e) {
            log.info(e.getMessage());
        }finally {
            wb.close();
        }
    }
    
}
