package com.wms.service.dto;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.validators.MustMatchRegexExpression;
import com.opencsv.bean.validators.PreAssignmentValidator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiersCsvDTO implements Serializable { 
    @PreAssignmentValidator(validator = MustMatchRegexExpression.class, paramString = "^[0-9]{10}$")
    @CsvBindByName(column = "identifiantFiscal", required = true)
    private String identifiantFiscal;
    @CsvBindByName(column = "designation", required = true)
    private String designation;
    @CsvBindByName(column = "activite", required = true)
    private String activite;
    @CsvBindByName(column = "adresse", required = true)
    private String adresse;
    @PreAssignmentValidator(validator = MustMatchRegexExpression.class, paramString = "^[0-9]{24}$")
    @CsvBindByName(column = "rib", required = true)
    private String rib;
    @CsvBindByName(column = "email", required = true)
    private String email;
    @PreAssignmentValidator(validator = MustMatchRegexExpression.class, paramString = "^[0-9]{15}$")
    @CsvBindByName(column = "ice", required = true)
    private String ice;
    @CsvBindByName(column = "registreCommerce", required = true)
    private String registreCommerce;
    @CsvBindByName(column = "telephone", required = true)
    private String telephone;
    @CsvBindByName(column = "ville", required = true)
    private String ville;
    @CsvBindByName(column = "banque", required = true)
    private String banque;
    @CsvBindByName(column = "echeance", required = true)
    private String echeance;
    @CsvBindByName(column = "typeEcheance", required = true)
    private String typeEcheance;
    @CsvBindByName(column = "devise", required = true)
    private String devise;
}
